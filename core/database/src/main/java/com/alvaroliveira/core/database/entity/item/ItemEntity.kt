package com.alvaroliveira.core.database.entity.item

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    var idItemEntity: Long = 0L,
    var keyOfItem: String = "",

    var itemData: ItemDataEntity? = ItemDataEntity(),

    var libraryOfItem: ItemLibraryEntity? = ItemLibraryEntity(),

    var linksOfItem: ItemLinksXEntity? = ItemLinksXEntity(),

    var metaOfItem: ItemMetaEntity? = ItemMetaEntity(),

    var versionOfItem: Int? = 0,

    var collectionKey: String = ""
)
