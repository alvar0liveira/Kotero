package com.alvaroliveira.core.database.entity.collection

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collections")
data class CollectionEntity(
    @PrimaryKey(autoGenerate = true)
    var idCollectionEntity: Long = 0L,
    var keyOfCollectionEntity: String = "",
    @Embedded
    var dataOfCollection: CollectionDataEntity = CollectionDataEntity(),
    @Embedded
    var library: CollectionLibraryEntity = CollectionLibraryEntity(),
    @Embedded
    var linksXOfCollectionEntity: CollectionLinksXEntity= CollectionLinksXEntity(),
    @Embedded
    var metaOfCollection: CollectionMetaEntity = CollectionMetaEntity(),
    var versionOfCollectionEntity: Int = 0
)