package com.alvaroliveira.features.main

import com.alvaroliveira.core.ui.UiSingleEvent

sealed class CollectionUiSingleEvent : UiSingleEvent {
    data class OpenItemsList(val route: String, val collectionKey: String): CollectionUiSingleEvent()
    data class OpenItem(val route: String, val itemKey: String, val collectionKey: String): CollectionUiSingleEvent()
    data class OpenPDF(val route: String, val itemKey: String, val apiKey: String, val userId: String) : CollectionUiSingleEvent()
}