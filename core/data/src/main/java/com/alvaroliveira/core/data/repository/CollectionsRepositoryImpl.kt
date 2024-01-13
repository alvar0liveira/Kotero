package com.alvaroliveira.core.data.repository

import com.alvaroliveira.core.data.datasource.local.CollectionLocalDataSource
import com.alvaroliveira.core.data.datasource.remote.CollectionRemoteDataSource
import com.alvaroliveira.core.model.collection.CollectionsItem
import com.alvaroliveira.core.model.collection.toCollectionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

class CollectionsRepositoryImpl(
    private val localDataSource: CollectionLocalDataSource,
    private val remoteDataSource: CollectionRemoteDataSource
): CollectionsRepository {
    override suspend fun getAllCollections(userId: String): Flow<List<CollectionsItem>> {
        val localCollections = localDataSource.getCollections().first()
        return if(localCollections.isNotEmpty()){
            flowOf(localCollections)
        } else {
            remoteDataSource
                .getAllCollections(userId)
                .onEach { collections ->
                    runBlocking {
                        localDataSource.deleteAllCollections()
                    }
                    collections.forEach {
                        localDataSource.insertCollection(it)
                    }

                }
        }
    }
}