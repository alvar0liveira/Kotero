package com.alvaroliveira.core.database.entity.item

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemSelf")
data class ItemSelfEntity(
    @PrimaryKey(autoGenerate = true)
    var idItemSelfEntity: Long = 0L,
    var hrefOfItem: String = "",
    var typeOfItem: String = ""
)