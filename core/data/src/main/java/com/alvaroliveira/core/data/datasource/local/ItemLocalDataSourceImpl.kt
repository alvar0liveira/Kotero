package com.alvaroliveira.core.data.datasource.local

import ItemItem
import com.alvaroliveira.core.database.dao.ItemDao
import com.alvaroliveira.core.database.entity.item.ItemEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import toItemItem

class ItemLocalDataSourceImpl(
    private val dao: ItemDao
) : ItemLocalDataSource {
    override suspend fun insertAllItems(items: List<ItemEntity>) {
        dao.insertItems(items)
    }

    override suspend fun insertItem(item: ItemEntity) {
        dao.insertItem(item)
    }

    override suspend fun getItems(collectionKey: String): Flow<List<ItemItem>> {
        return dao
            .getItems(collectionKey)
            .map {
                it.map {
                    it.toItemItem()
                }
            }
    }

    override suspend fun deleteAllItems(collectionKey: String) {
        dao.deleteItems(collectionKey)
    }

    override suspend fun getItem(itemKey: String): Flow<ItemItem> {
        return dao.getItem(itemKey).map {
            it.toItemItem()
        }
    }

}