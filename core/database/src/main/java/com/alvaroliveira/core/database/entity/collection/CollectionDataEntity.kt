package com.alvaroliveira.core.database.entity.collection

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alvaroliveira.core.database.entity.item.ItemEntity

@Entity(tableName = "collectionsData")
data class CollectionDataEntity(
    @PrimaryKey(autoGenerate = true)
    var idCollectionData: Long = 0L,
    var keyOfCollection: String = "",
    var nameOfCollection: String = "",
    var parentCollection: Boolean = false,
//    @Embedded
//    var relations: CollectionRelationsEntity,
    var versionOfCollection: Int = 0,
)
