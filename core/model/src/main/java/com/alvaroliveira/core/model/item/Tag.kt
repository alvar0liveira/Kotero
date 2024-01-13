package com.alvaroliveira.core.model.item


import com.alvaroliveira.core.database.entity.item.ItemTagEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "tag")
    val tag: String?,
    @Json(name = "type")
    val type: Int?
)

fun Tag.toTagEntity(): ItemTagEntity {
    return ItemTagEntity(
        tag = tag.orEmpty(),
        typeOfItem = type ?: 0
    )
}

fun ItemTagEntity.toTagE(): Tag {
    return Tag(
        tag = tag,
        type = typeOfItem
    )
}