package com.alvaroliveira.core.model.collection


import com.alvaroliveira.core.database.entity.collection.CollectionMetaEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "numCollections")
    val numCollections: Int,
    @Json(name = "numItems")
    val numItems: Int
)

fun Meta.toCollectionMetaEntity(): CollectionMetaEntity {
    return CollectionMetaEntity(
        numCollections = numCollections,
        numItems = numItems
    )
}

fun CollectionMetaEntity.toCollectionMeta(): Meta {
    return Meta(
        numCollections = numCollections,
        numItems = numItems
    )
}