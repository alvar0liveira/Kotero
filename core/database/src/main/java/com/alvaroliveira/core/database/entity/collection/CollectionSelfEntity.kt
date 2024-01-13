package com.alvaroliveira.core.database.entity.collection

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collectionsSelf")
data class CollectionSelfEntity(
    @PrimaryKey(autoGenerate = true)
    var idCollectionSelfEntity: Long = 0L,
    var href: String = "",
    var type: String = ""
)