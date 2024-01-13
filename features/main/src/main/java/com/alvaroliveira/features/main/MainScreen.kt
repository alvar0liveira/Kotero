package com.alvaroliveira.features.main

import ItemItem
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.alvaroliveira.core.model.collection.CollectionsItem
import com.alvaroliveira.core.model.item.Data
import com.alvaroliveira.core.ui.CommonScreen
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last


private const val TAG = "MainScreen"

@Composable
fun CollectionsScreen(
    viewModel: MainViewModel,
    navController: NavController,
) {
    LaunchedEffect(key1 = Unit){
        viewModel.submitAction(CollectionUiAction.LoadCollections)
    }

    viewModel.uiStateFlow.collectAsStateWithLifecycle().value.let { state ->
        CommonScreen(state = state) {
            it.collections?.let { col ->
                CollectionsList(colState = col , onNavigateToCollection = { collectionKey ->
                    viewModel.submitSingleEvent(CollectionUiSingleEvent.OpenItemsList(MainGraph.ItemsScreen.route, collectionKey))
                })
            }
        }
    }
    
    LaunchedEffect(key1 = Unit){
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is CollectionUiSingleEvent.OpenItemsList -> {
                    navController.navigate(it.route + "/{collectionId}".replace(oldValue = "{collectionId}", newValue = it.collectionKey))
                }
                is CollectionUiSingleEvent.OpenItem -> {
                    navController.navigate(it.route + "/{collectionId}/{itemKey}"
                        .replace(oldValue = "{collectionId}", newValue = it.collectionKey)
                        .replace(oldValue = "{itemKey}", newValue = it.itemKey)
                    )
                }
                is CollectionUiSingleEvent.OpenPDF -> {
                    navController.navigate(it.route + "/{itemKey}" + "/{apiKey}" + "/{userId}"
                        .replace(oldValue = "{itemKey}", newValue = it.itemKey)
                        .replace(oldValue = "{apiKey}", newValue = it.apiKey)
                        .replace(oldValue = "{userId}", newValue = it.userId)
                    )
                }
            }
        }
    }
}



@Composable
fun CollectionsList(colState: List<CollectionsItem>, onNavigateToCollection: (key: String) -> Unit) {
    LazyColumn(modifier = Modifier.padding(16.dp)){
        items(colState){collection ->
            CollectionRow(collection = collection) {
                onNavigateToCollection(it)
            }
        }
    }
}

@Composable
fun CollectionRow(
    collection: CollectionsItem,
    onClick: (key: String) -> Unit
) {
    IconButton(onClick = { onClick(collection.key) }, modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text(text = collection.data.name)
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Go to collection")
        }
    }
}

@Composable
fun CollectionScreen(
    viewModel: MainViewModel,
    navController: NavController,
    collectionId: String,
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.submitAction(CollectionUiAction.LoadItems(collectionId))
    }

    viewModel.uiStateFlow.collectAsStateWithLifecycle().value.let { state ->
        CommonScreen(state = state) {
            it.items?.let {
                ItemsList(itemCollections = it, onCollectionClick = {
                    viewModel.submitSingleEvent(CollectionUiSingleEvent.OpenItem(
                        MainGraph.ItemScreen.route,
                        collectionKey = collectionId,
                        itemKey = it
                    ))
                })
            }
        }
    }

    LaunchedEffect(key1 = Unit){
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is CollectionUiSingleEvent.OpenItem -> {
                    navController.navigate(it.route + "/{collectionId}/{itemKey}"
                        .replace(oldValue = "{collectionId}", newValue = it.collectionKey)
                        .replace(oldValue = "{itemKey}", newValue = it.itemKey)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemsList(
    itemCollections: List<ItemItem>,
    onCollectionClick: (itemKey: String) -> Unit
) {
    LazyColumn(){
        items(itemCollections){
            Text(
                text = it.itemData?.title.orEmpty(),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable(enabled = true) {
                        onCollectionClick(it.key)
                    }
            )
            Divider(modifier = Modifier.height(1.5.dp))
        }
    }
}


@Composable
fun ItemScreen(
    viewModel: MainViewModel,
    navController: NavController,
    item: String,
    collectionKey: String
) {
    val apiKey = produceState(initialValue = ""){
        value = viewModel.getApiKey().first()
    }

    val userId = produceState(initialValue = ""){
        value = viewModel.getUserId().first()
    }
    LaunchedEffect(key1 = Unit){
        viewModel.submitAction(CollectionUiAction.LoadItem(itemKey = item, collectionKey = collectionKey))
    }

    LaunchedEffect(key1 = Unit){
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is CollectionUiSingleEvent.OpenPDF -> {
                    navController.navigate(it.route + "/{itemKey}/{apiKey}/{userId}"
                        .replace(oldValue = "{itemKey}", newValue = it.itemKey)
                        .replace(oldValue = "{apiKey}", newValue = it.apiKey)
                        .replace(oldValue = "{userId}", newValue = it.userId)
                    )
                }
            }
        }
    }

    viewModel.uiStateFlow.collectAsStateWithLifecycle().value.let { state ->
        CommonScreen(state = state) {
            it.item?.let {
                ItemComposable(item = it) {
                    viewModel.submitSingleEvent(CollectionUiSingleEvent.OpenPDF(MainGraph.PDFScreen.route, itemKey = it, apiKey = apiKey.value, userId = userId.value))
                }
            }
        }
    }
}

@Composable
fun ItemComposable(
    item: ItemItem,
    onOpenPDF: (key: String) -> Unit = {}
) {
    when(item.itemData?.itemType){
        "journalArticle" -> JournalArticle(item = item, onOpenPDF = onOpenPDF)
        else -> Text(text = item.itemData?.title.orEmpty())
    }

}

@Composable
fun JournalArticle(
    item: ItemItem,
    onOpenPDF: (key: String) -> Unit
) {
    val itemData = item.itemData!!
    val links = item.links!!
    val link = (if (links.attachment?.href?.isNotEmpty() == true) links.attachment?.href?.takeLast(8) else links.alternate?.href?.takeLast(8)).orEmpty()

    Column {
        Text(text = itemData.title.orEmpty())
        Text(text = itemData.abstractNote.orEmpty())
        Text(text = itemData.dOI.orEmpty())
        Text(text = links.attachment?.href.orEmpty())
        Text(text = links.alternate?.href.orEmpty())
        Text(text = link)
        Button(onClick = { onOpenPDF(link) }) {
            Text(text = "Open PDF")
        }
    }
}


@Composable
fun PDFScreen(
    key: String,
    apiKey: String,
    userId: String
) {
    val pdfState = rememberVerticalPdfReaderState(
        resource = ResourceType.Remote(url = "https://api.zotero.org/users/$userId/items/$key/file/view",
            headers = hashMapOf("Authorization" to "Bearer $apiKey")),
        isZoomEnable = true
    )
    LaunchedEffect(key1 = pdfState.error){
        pdfState.error?.let {
            Log.w("AHAHAHAH", it)
        }
    }

    VerticalPDFReader(state = pdfState, modifier = Modifier.fillMaxSize())
}