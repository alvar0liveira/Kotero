package com.alvaroliveira.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alvaroliveira.core.database.entity.collection.CollectionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CollectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(collection: CollectionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollections(collections: List<CollectionEntity>)

    @Query("DELETE  FROM collections")
    suspend fun deleteCollections()

//    @Query("DELETE FROM items WHERE `keyOfItem`=:key")
//    suspend fun deleteNote(key: String)

    @Query("SELECT * FROM collections")
    fun getCollections(): Flow<List<CollectionEntity>>

//    @Query("SELECT * FROM items WHERE `keyOfItem`=:key ORDER BY dateModified DESC")
//    suspend fun getCollection(key: String): CollectionEntity

}