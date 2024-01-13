package com.alvaroliveira.core.data.datasource.remote

import ItemItem
import kotlinx.coroutines.flow.Flow

interface ItemRemoteDataSource {
    suspend fun getItems(
        userId: String,
        collectionKey: String
    ): Flow<List<ItemItem>>

    suspend fun getItem(
        userId: String,
        itemKey: String,
    ): Flow<ItemItem>
}