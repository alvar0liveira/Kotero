package com.alvaroliveira.core.database.entity.collection

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collectionsUp")
data class CollectionUpEntity(
    @PrimaryKey(autoGenerate = true)
    var idCollectionUp: Long = 0L,
    var hrefOfCollectionUp: String = "",
    var typeOfCollectionUp: String = ""
)
