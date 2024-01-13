package com.alvaroliveira.core.model.collection


import com.alvaroliveira.core.database.entity.collection.CollectionUpEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Up(
    @Json(name = "href")
    val href: String,
    @Json(name = "type")
    val type: String
)

fun Up.toCollectionUpEntity(): CollectionUpEntity {
    return CollectionUpEntity(
        hrefOfCollectionUp = href,
        typeOfCollectionUp = type
    )
}

fun CollectionUpEntity.toUp(): Up {
    return Up(
        href = hrefOfCollectionUp,
        type = typeOfCollectionUp
    )
}
