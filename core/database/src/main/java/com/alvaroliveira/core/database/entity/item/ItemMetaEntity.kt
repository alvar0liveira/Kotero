package com.alvaroliveira.core.database.entity.item

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemMeta")
data class ItemMetaEntity(
    @PrimaryKey(autoGenerate = true)
    var idItemMeta: Long = 0L,
    var creatorSummary: String? = "",
    var numChildren: Int? = 0,
    var parsedDate: String? = ""
)