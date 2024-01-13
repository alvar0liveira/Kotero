package com.alvaroliveira.features.main

import ItemItem
import com.alvaroliveira.core.model.collection.CollectionsItem

data class CollectionModel(
    val collections: List<CollectionsItem>?,
    val items: List<ItemItem>?,
    val item: ItemItem?
)
