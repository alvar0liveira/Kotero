package com.alvaroliveira.core.data.repository

import ItemItem
import com.alvaroliveira.core.data.datasource.local.ItemLocalDataSource
import com.alvaroliveira.core.data.datasource.remote.ItemRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import toItemEntity

class ItemsRepositoryImpl(
    private val localDataSource: ItemLocalDataSource,
    private val remoteDataSource: ItemRemoteDataSource
): ItemsRepository {
    override suspend fun getItemsCollection(
        userId: String,
        collectionId: String,
        limit: Int,
        start: Int
    ): Flow<List<ItemItem>> {
        return flow {
            val localItems = localDataSource.getItems(collectionId).firstOrNull()
            if(!localItems.isNullOrEmpty()){
                emit(localItems)
            } else {
                remoteDataSource
                    .getItems(userId, collectionId)
                    .collect { items ->
                        localDataSource.deleteAllItems(collectionId)
                        items.forEach { item ->
                            item
                                .toItemEntity()
                                .apply {
                                    collectionKey = collectionId
                                }
                                .also {
                                    localDataSource.insertItem(it)
                                }
                        }

                    }
            }


        }
    }

    override suspend fun getItem(userId: String, itemKey: String, collectionKey: String): Flow<ItemItem> {
        return flow {
            val localItem = localDataSource.getItem(itemKey).firstOrNull()
            if(localItem != null){
                emit(localItem)
            } else {
                remoteDataSource
                    .getItem(userId, itemKey)
                    .collect {
                        it.toItemEntity()
                            .copy(
                                collectionKey = collectionKey
                            ).also {
                                localDataSource.insertItem(it)
                            }
                    }
            }
        }
    }
}