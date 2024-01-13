package com.alvaroliveira.core.database.entity.collection

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collectionsAlternate")
data class CollectionAlternateEntity(
    @PrimaryKey(autoGenerate = true)
    var idCollectionAlternate: Long = 0L,
    var hrefCollectionAlternateCAE: String = "",
    var typeCollectionAlternateCAE: String = ""
)
