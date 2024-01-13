package com.alvaroliveira.core.data.datasource.remote

import CollectionsService
import ItemItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ItemRemoteDataSourceImpl(
    private val api: CollectionsService
): ItemRemoteDataSource {
    override suspend fun getItems(userId: String, collectionKey: String): Flow<List<ItemItem>> {
        return flowOf(api.getTopItemsCollection(userId, collectionKey))
    }

    override suspend fun getItem(userId: String, itemKey: String): Flow<ItemItem> {
        return flowOf(api.getItem(userId, itemKey))
    }
}