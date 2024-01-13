package com.alvaroliveira.core.data.datasource.local

import ItemItem
import android.content.ClipData.Item
import com.alvaroliveira.core.database.entity.item.ItemEntity
import kotlinx.coroutines.flow.Flow

interface ItemLocalDataSource {
    suspend fun insertAllItems(items: List<ItemEntity>)
    suspend fun insertItem(item: ItemEntity)
    suspend fun getItems(collectionKey: String): Flow<List<ItemItem>>
    suspend fun deleteAllItems(collectionKey: String)
    suspend fun getItem(itemKey: String): Flow<ItemItem>
}