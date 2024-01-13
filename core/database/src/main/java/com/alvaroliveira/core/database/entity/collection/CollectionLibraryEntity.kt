package com.alvaroliveira.core.database.entity.collection

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collectionsLibrary")
data class CollectionLibraryEntity(
    @PrimaryKey(autoGenerate = true)
    var idOfCollectionLibrary: Long = 0L,
    var linksOfCollectionLibrary: CollectionLinksEntity = CollectionLinksEntity(),
    var nameOfCollectionLibrary: String = "",
    var typeOfCollectionLibrary: String = ""
)
