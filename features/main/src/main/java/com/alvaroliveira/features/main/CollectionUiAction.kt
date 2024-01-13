package com.alvaroliveira.features.main

import com.alvaroliveira.core.ui.UiAction

sealed class CollectionUiAction : UiAction {

    data object LoadCollections : CollectionUiAction()

    data class LoadItems(
        val collectionKey: String
    ) : CollectionUiAction()

    data class LoadItem(
        val itemKey: String,
        val collectionKey: String
    ): CollectionUiAction()

    data class CollectionClick(val collectionKey: String): CollectionUiAction()
    data class ItemClick(
        val itemKey: String,
        val collectionKey: String
    ): CollectionUiAction()

    data class OpenPDF(
        val itemKey: String,
        val apiKey: String,
        val userId: String
    ) : CollectionUiAction()
}
