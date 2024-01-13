package com.alvaroliveira.core.database.entity.item

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemAlternate")
data class ItemAlternateEntity(
    @PrimaryKey(autoGenerate = true)
    var idItemAlternate: Long = 0L,
    var hrefOfItemAlternateEntity: String = "",
    var typeOfItemAlternateEntity: String = ""
)
