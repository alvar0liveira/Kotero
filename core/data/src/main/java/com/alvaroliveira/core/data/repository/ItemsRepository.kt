package com.alvaroliveira.core.data.repository

import ItemItem
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    suspend fun getItemsCollection(
        userId: String,
        collectionId: String,
        limit: Int = 100,
        start: Int = 0
    ): Flow<List<ItemItem>>

    suspend fun getItem(
        userId: String,
        itemKey: String,
        collectionKey: String,
    ): Flow<ItemItem>
}