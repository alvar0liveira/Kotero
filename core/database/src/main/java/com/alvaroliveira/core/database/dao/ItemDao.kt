package com.alvaroliveira.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alvaroliveira.core.database.entity.collection.CollectionEntity
import com.alvaroliveira.core.database.entity.item.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ItemEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<ItemEntity>)

    @Query("DELETE  FROM items WHERE collectionKey=:collectionKey")
    suspend fun deleteItems(collectionKey: String)

//    @Query("DELETE FROM items WHERE `keyOfItem`=:key")
//    suspend fun deleteNote(key: String)

    @Query("SELECT * FROM items WHERE collectionKey=:collectionKey")
    fun getItems(collectionKey: String): Flow<List<ItemEntity>>

    @Query("SELECT * FROM items WHERE keyOfItem=:itemKey")
    fun getItem(itemKey: String): Flow<ItemEntity>
}