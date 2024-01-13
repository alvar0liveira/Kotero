package com.alvaroliveira.core.model.common


import com.alvaroliveira.core.database.entity.collection.CollectionLinksEntity
import com.alvaroliveira.core.database.entity.item.ItemLinksEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "alternate")
    val alternate: Alternate,
    @Json(name = "attachment")
    val attachment: Alternate?
)

fun Links.toCollectionLinksEntity(): CollectionLinksEntity{
    return CollectionLinksEntity(
        alternateOfOfCollectionLinks = alternate.toCollectionAlternateEntity(),
        attachmentOfCollectionLinks =  attachment.toCollectionAlternateEntity()
    )
}

fun Links.toItemLinksEntity(): ItemLinksEntity{
    return ItemLinksEntity(
        alternateOfItemLinks = alternate.toItemAlternateEntity(),
        attachmentOfItemLinks = attachment.toItemAlternateEntity()
    )
}

fun CollectionLinksEntity.toLinks(): Links{
    return Links(
        alternate = alternateOfOfCollectionLinks.toAlternate(),
        attachment = alternateOfOfCollectionLinks.toAlternate()
    )
}

fun ItemLinksEntity.toLinks(): Links{
    return Links(
        alternate = alternateOfItemLinks.toAlternate(),
        attachment = alternateOfItemLinks.toAlternate()
    )
}