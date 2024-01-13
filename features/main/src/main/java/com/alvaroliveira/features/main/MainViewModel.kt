package com.alvaroliveira.features.main

import CollectionsService
import ItemItem
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvaroliveira.core.common.UseCase
import com.alvaroliveira.core.data.usecase.GetAllCollectionsUseCase
import com.alvaroliveira.core.data.usecase.GetAllItemsByCollectionUseCase
import com.alvaroliveira.core.data.usecase.GetCollectionItemsUseCase
import com.alvaroliveira.core.data.usecase.GetItemByCollectionUseCase
import com.alvaroliveira.core.datastore.AppDataStore
import com.alvaroliveira.core.model.collection.CollectionsItem
import com.alvaroliveira.core.ui.MviViewModel
import com.alvaroliveira.core.ui.UiSingleEvent
import com.alvaroliveira.core.ui.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


private const val TAG = "MainViewModel"

class MainViewModel(
    private val appDataStore: AppDataStore,
    private val getAllCollectionsUseCase: UseCase<GetAllCollectionsUseCase.Request, GetAllCollectionsUseCase.Response>,
    private val getCollectionItemsUseCase: UseCase<GetCollectionItemsUseCase.Request, GetCollectionItemsUseCase.Response>,
    private val getAllItemsByCollectionUseCase: UseCase<GetAllItemsByCollectionUseCase.Request, GetAllItemsByCollectionUseCase.Response>,
    private val getItemByCollectionUseCase: UseCase<GetItemByCollectionUseCase.Request, GetItemByCollectionUseCase.Response>
): MviViewModel<CollectionModel, UiState<CollectionModel>, CollectionUiAction, UiSingleEvent>() {

    private var service: CollectionsService? = null
    var col: StateFlow<List<CollectionsItem>?> = MutableStateFlow(null)
    val id: MutableStateFlow<String> = MutableStateFlow<String>("")
    var isLoading = MutableStateFlow(true)
    var requestCount = 0
    private var apiKey: String = ""
    var items: StateFlow<List<ItemItem>?> = MutableStateFlow(null)
    val item: MutableStateFlow<ItemItem?> = MutableStateFlow(null)
    val pdfUrl: MutableStateFlow<String?> = MutableStateFlow(null)
    val maxResults: MutableStateFlow<Int> = MutableStateFlow(0)
    val pages: MutableStateFlow<Int> = MutableStateFlow(0)
    val allItems: MutableStateFlow<MutableList<ItemItem>> = MutableStateFlow(emptyList<ItemItem>().toMutableList())
    var userId = appDataStore.savedUserId.stateIn(viewModelScope, SharingStarted.Eagerly, "")

    init {
        viewModelScope.launch {
            appDataStore.savedApiKey.filterNot {
                it.isEmpty()
            }.collectLatest {
                apiKey = it
            }
//            appDataStore.savedUserId.filterNot {
//                it.isEmpty()
//            }.collectLatest {
//                userId = it
//            }
        }
        Log.w("AHAHAHAHAH", "Client: $service ")
    }


    fun getUserId(): Flow<String>{
        return appDataStore.savedUserId
    }

    fun getApiKey(): Flow<String>{
        return appDataStore.savedApiKey
    }

    fun getAllCollections() {
        viewModelScope.launch {
             getAllCollectionsUseCase.execute(
                GetAllCollectionsUseCase.Request(userId.value)
            ).collect {
                it.onSuccess { response ->
                    submitState(UiState.Success(CollectionModel(response.collections, null, null)))
                }
                 it.onFailure {
                     submitState(UiState.Error("Failed to get Collections"))
                 }
            }
        }
        Log.e(TAG, "getAllCollections: ${maxResults.value}")
        Log.e(TAG, "getAllCollections: Pages${pages.value}")
        isLoading.value = false
    }

    override fun initState(): UiState<CollectionModel> = UiState.Loading

    override fun handleAction(action: CollectionUiAction) {
        when(action){
            is CollectionUiAction.LoadCollections -> {
                getAllCollections()
            }
            is CollectionUiAction.LoadItems -> {
                getItemsForCollection(userId.value, action.collectionKey)
            }

            is CollectionUiAction.LoadItem -> {
                getItemForCollection(userId.value, action.itemKey, action.collectionKey)
            }
            is CollectionUiAction.CollectionClick -> {
                submitSingleEvent(
                    CollectionUiSingleEvent
                        .OpenItemsList(
                            MainGraph.ItemsScreen.route,
                            collectionKey = action.collectionKey
                        )
                )
            }
            is  CollectionUiAction.ItemClick -> {
                submitSingleEvent(
                    CollectionUiSingleEvent
                        .OpenItem(
                            MainGraph.ItemScreen.route,
                            itemKey = action.itemKey,
                            collectionKey = action.collectionKey
                        )
                )
            }
            is CollectionUiAction.OpenPDF -> {
                submitSingleEvent(
                    CollectionUiSingleEvent
                        .OpenPDF(
                            MainGraph.PDFScreen.route,
                            itemKey = action.itemKey,
                            apiKey = action.apiKey,
                            userId = action.userId
                        )
                )
            }
        }
    }

    fun getItemsForCollection(userId: String, collectionKey: String){
        viewModelScope.launch {
            initState()
            getAllItemsByCollectionUseCase.execute(
                GetAllItemsByCollectionUseCase.Request(
                    userId = userId,
                    collectionKey = collectionKey
                )
            ).collect {
                it.onSuccess {
                    submitState(
                        UiState.Success(
                            CollectionModel(null, it.items, null)
                        )
                    )
                }

                it.onFailure {
                    it
                    submitState(
                        UiState.Error("Failed to get Item")
                    )
                }
            }
        }
    }

    fun getItemForCollection(userId: String, itemKey: String, collectionKey: String){
        initState()
        viewModelScope.launch {
            getItemByCollectionUseCase.execute(
                GetItemByCollectionUseCase.Request(
                    userId= userId,
                    itemKey = itemKey,
                    collectionKey = collectionKey
                )
            ).collect {
                it.onSuccess {
                    submitState(
                        UiState.Success(
                            CollectionModel(null, null, it.item)
                        )
                    )
                }
                it.onFailure {
                    submitState(
                        UiState.Error("Failed to get Item")
                    )
                }
            }
        }
    }

//    fun getItem(
//        itemKey: String
//    ){
//        viewModelScope.launch {
//            item.emit(service?.getItem(userId, itemKey = itemKey))
//        }
//    }

//    fun getPDF(
//        itemKey: String
//    ) {
//        viewModelScope.launch {
//            val call: Call<Nothing> = service?.getPDF(userId, itemKey)!!
//            call.enqueue(object : Callback<Nothing> {
//                override fun onResponse(call: Call<Nothing>, response: Response<Nothing>) {
//                    viewModelScope.launch {
//                        response.headers()["Location"]?.let {
//                            pdfUrl.emit(it)
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<Nothing>, t: Throwable) {
//                }
//
//            })
//        }
//    }



//    private fun injectRetrofit(token: String){
//        service = inject<CollectionsService>(CollectionsService::class.java){
//            parametersOf(token)
//        }.value
//    }
}