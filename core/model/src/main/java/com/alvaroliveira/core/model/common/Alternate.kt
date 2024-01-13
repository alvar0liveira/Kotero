package com.alvaroliveira.core.model.common


import com.alvaroliveira.core.database.entity.collection.CollectionAlternateEntity
import com.alvaroliveira.core.database.entity.item.ItemAlternateEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Alternate(
    @Json(name = "href")
    val href: String,
    @Json(name = "type")
    val type: String
)

fun Alternate?.toCollectionAlternateEntity(): CollectionAlternateEntity {
    return CollectionAlternateEntity(
        hrefCollectionAlternateCAE = this?.href.orEmpty(),
        typeCollectionAlternateCAE = this?.type.orEmpty()
    )
}

fun Alternate?.toItemAlternateEntity(): ItemAlternateEntity {
    return ItemAlternateEntity(
        hrefOfItemAlternateEntity = this?.href.orEmpty(),
        typeOfItemAlternateEntity = this?.type.orEmpty()
    )
}

fun CollectionAlternateEntity.toAlternate(): Alternate{
    return Alternate(
        href = hrefCollectionAlternateCAE,
        type = typeCollectionAlternateCAE
    )
}

fun ItemAlternateEntity.toAlternate(): Alternate{
    return Alternate(
        href = hrefOfItemAlternateEntity,
        type = typeOfItemAlternateEntity
    )
}
