package com.alvaroliveira.core.model.collection


import com.alvaroliveira.core.database.entity.collection.CollectionLinksXEntity
import com.alvaroliveira.core.database.entity.item.ItemLinksXEntity
import com.alvaroliveira.core.model.common.Alternate
import com.alvaroliveira.core.model.common.Self
import com.alvaroliveira.core.model.common.toAlternate
import com.alvaroliveira.core.model.common.toCollectionAlternateEntity
import com.alvaroliveira.core.model.common.toCollectionSelfEntity
import com.alvaroliveira.core.model.common.toItemAlternateEntity
import com.alvaroliveira.core.model.common.toItemSelfEntity
import com.alvaroliveira.core.model.common.toLinks
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksX(
    @Json(name = "alternate")
    val alternate: Alternate,
    @Json(name = "self")
    val self: Self,
    @Json(name = "up")
    val up: Up?
)

fun LinksX.toCollectionLinksXEntity(): CollectionLinksXEntity {
    return CollectionLinksXEntity(
        alternateOfCollectionEntity = alternate.toCollectionAlternateEntity(),
        self = self.toCollectionSelfEntity(),
        up = up?.toCollectionUpEntity()
    )
}

fun LinksX.toItemLinksEntity(): ItemLinksXEntity {
    return ItemLinksXEntity(
        alternateOfItemLinksX = alternate.toItemAlternateEntity(),
        selfOfItemLinksX = self.toItemSelfEntity()
    )
}

fun CollectionLinksXEntity.toLinksX(): LinksX {
    return LinksX(
        alternate = alternateOfCollectionEntity.toAlternate(),
        self = self.toLinks(),
        up = up?.toUp()
    )
}
