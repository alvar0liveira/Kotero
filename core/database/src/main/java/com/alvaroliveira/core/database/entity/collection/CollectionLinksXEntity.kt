package com.alvaroliveira.core.database.entity.collection

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collectionsLinksX")
data class CollectionLinksXEntity(
    @PrimaryKey
    val idCollectionLinksX: Long = 0L,
    val alternateOfCollectionEntity: CollectionAlternateEntity = CollectionAlternateEntity(),
    val self: CollectionSelfEntity = CollectionSelfEntity(),
    val up: CollectionUpEntity? = CollectionUpEntity()
)
