package com.alvaroliveira.core.model.item


import com.alvaroliveira.core.database.entity.item.ItemMetaEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "creatorSummary")
    val creatorSummary: String?,
    @Json(name = "numChildren")
    val numChildren: Int?,
    @Json(name = "parsedDate")
    val parsedDate: String?
)

fun Meta.toItemMetaEntity(): ItemMetaEntity {
    return ItemMetaEntity(
        creatorSummary = creatorSummary,
        numChildren = numChildren,
        parsedDate = parsedDate
    )
}

fun ItemMetaEntity.toItemMeta(): Meta {
    return Meta(
        creatorSummary = creatorSummary,
        numChildren = numChildren,
        parsedDate = parsedDate
    )
}