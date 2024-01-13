package com.alvaroliveira.core.database.entity.collection

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collectionsLinks")
data class CollectionLinksEntity(
    @PrimaryKey(autoGenerate = true)
    var idCollectionLinksEntity: Long = 0L,
    var alternateOfOfCollectionLinks: CollectionAlternateEntity = CollectionAlternateEntity(),
    var attachmentOfCollectionLinks: CollectionAlternateEntity = CollectionAlternateEntity(),
)
