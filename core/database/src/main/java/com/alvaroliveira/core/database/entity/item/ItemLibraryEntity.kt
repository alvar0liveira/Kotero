package com.alvaroliveira.core.database.entity.item

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemLibrary")
data class ItemLibraryEntity(
    @PrimaryKey(autoGenerate = true)
    var idOfItemLibrary: Long = 0,
    var linksOfItemLibrary: ItemLinksEntity = ItemLinksEntity(),
    var nameOfItemLibrary: String = "",
    var typeOfItemLibrary: String = ""
)
