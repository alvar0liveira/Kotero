package com.alvaroliveira.core.data.datasource.remote

import CollectionsService
import com.alvaroliveira.core.model.collection.CollectionsItem
import com.alvaroliveira.core.network.ZoteroTokenInterceptor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CollectionRemoteDataSourceImpl(
    private val api: CollectionsService,
): CollectionRemoteDataSource, KoinComponent{

    override suspend fun getAllCollections(userId: String): Flow<List<CollectionsItem>> {
        return flowOf(api.getAllCollections(userId))
    }
}