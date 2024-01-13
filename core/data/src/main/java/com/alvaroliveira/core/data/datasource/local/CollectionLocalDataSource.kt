package com.alvaroliveira.core.data.datasource.local

import com.alvaroliveira.core.model.collection.Collections
import com.alvaroliveira.core.model.collection.CollectionsItem
import kotlinx.coroutines.flow.Flow

interface CollectionLocalDataSource {
    suspend fun insertAllCollections(collections: List<CollectionsItem>)
    suspend fun insertCollection(collection: CollectionsItem)
    suspend fun getCollections(): Flow<List<CollectionsItem>>
    suspend fun deleteAllCollections()
}