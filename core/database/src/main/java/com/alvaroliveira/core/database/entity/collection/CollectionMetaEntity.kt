package com.alvaroliveira.core.database.entity.collection

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collectionsMeta")
data class CollectionMetaEntity(
    @PrimaryKey(autoGenerate = true)
    var idCollectionMeta: Long = 0L,
    var numCollections: Int = 0,
    var numItems: Int  = 0
)
