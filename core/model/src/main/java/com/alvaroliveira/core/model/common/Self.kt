package com.alvaroliveira.core.model.common


import com.alvaroliveira.core.database.entity.collection.CollectionLinksEntity
import com.alvaroliveira.core.database.entity.collection.CollectionSelfEntity
import com.alvaroliveira.core.database.entity.item.ItemLinksEntity
import com.alvaroliveira.core.database.entity.item.ItemSelfEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Self(
    @Json(name = "href")
    val href: String,
    @Json(name = "type")
    val type: String
)


fun Self.toCollectionSelfEntity(): CollectionSelfEntity {
    return CollectionSelfEntity(
        href = href,
        type = type
    )
}

fun Self.toItemSelfEntity(): ItemSelfEntity {
    return ItemSelfEntity(
        hrefOfItem = href,
        typeOfItem = type
    )
}

fun CollectionSelfEntity.toLinks(): Self{
    return Self(
        href = href,
        type = type
    )
}

fun ItemSelfEntity.toLinks(): Self {
    return Self(
        href = hrefOfItem,
        type = typeOfItem
    )
}