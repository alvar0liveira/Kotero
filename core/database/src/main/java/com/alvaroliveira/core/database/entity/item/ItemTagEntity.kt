package com.alvaroliveira.core.database.entity.item

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemTags")
data class ItemTagEntity(
    @PrimaryKey(autoGenerate = true)
    val idItemTag: Long = 0L,
    val tag: String = "",
    val typeOfItem: Int = 0
)
