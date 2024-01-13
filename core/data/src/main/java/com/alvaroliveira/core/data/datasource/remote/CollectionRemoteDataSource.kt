package com.alvaroliveira.core.data.datasource.remote

import com.alvaroliveira.core.model.collection.CollectionsItem
import kotlinx.coroutines.flow.Flow

interface CollectionRemoteDataSource {
    suspend fun getAllCollections(userId: String): Flow<List<CollectionsItem>>
}