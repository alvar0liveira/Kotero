package com.alvaroliveira.core.database.entity.item

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemXlinks")
data class ItemLinksXEntity(
    @PrimaryKey(autoGenerate = true)
    var idLinksXEntity: Long = 0L,
    var alternateOfItemLinksX: ItemAlternateEntity = ItemAlternateEntity(),
    var attachmentOfItemLinksX: ItemAlternateEntity = ItemAlternateEntity(),
    var selfOfItemLinksX: ItemSelfEntity = ItemSelfEntity(),
)

