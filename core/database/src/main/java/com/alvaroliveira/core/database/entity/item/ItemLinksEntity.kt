package com.alvaroliveira.core.database.entity.item

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemLinks")
data class ItemLinksEntity(
    @PrimaryKey(autoGenerate = true)
    var idLinksEntity: Long = 0L,
    var alternateOfItemLinks: ItemAlternateEntity = ItemAlternateEntity(),
    var attachmentOfItemLinks: ItemAlternateEntity = ItemAlternateEntity(),
)
