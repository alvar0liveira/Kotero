package com.alvaroliveira.core.data.datasource.local

import com.alvaroliveira.core.database.dao.CollectionDao
import com.alvaroliveira.core.model.collection.CollectionsItem
import com.alvaroliveira.core.model.collection.toCollectionEntity
import com.alvaroliveira.core.model.collection.toCollectionsItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CollectionLocalDataSourceImpl(
    private val collectionsDao: CollectionDao
): CollectionLocalDataSource {
    override suspend fun insertAllCollections(collections: List<CollectionsItem>) {
        collections.forEach {
            collectionsDao.insertCollection(it.toCollectionEntity())
        }
    }

    override suspend fun insertCollection(collection: CollectionsItem) {
        collectionsDao.insertCollection(collection.toCollectionEntity())
    }

    override suspend fun getCollections(): Flow<List<CollectionsItem>> {
        return collectionsDao
                .getCollections()
                .map {
                    it.map {
                        it.toCollectionsItem()
                    }
                }
    }

    override suspend fun deleteAllCollections() {
        collectionsDao.deleteCollections()
    }
}