package com.alvaroliveira.core.model.item


import com.alvaroliveira.core.database.entity.item.ItemAlternateEntity
import com.alvaroliveira.core.database.entity.item.ItemLinksEntity
import com.alvaroliveira.core.database.entity.item.ItemLinksXEntity
import com.alvaroliveira.core.database.entity.item.ItemSelfEntity
import com.alvaroliveira.core.model.common.Alternate
import com.alvaroliveira.core.model.common.Links
import com.alvaroliveira.core.model.common.Self
import com.alvaroliveira.core.model.common.toAlternate
import com.alvaroliveira.core.model.common.toItemAlternateEntity
import com.alvaroliveira.core.model.common.toItemSelfEntity
import com.alvaroliveira.core.model.common.toLinks
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksX(
    @Json(name = "alternate")
    val alternate: Alternate?,
    @Json(name = "attachment")
    val attachment: Alternate?,
    @Json(name = "self")
    val self: Self?
)

fun LinksX.toItemLinksEntity(): ItemLinksXEntity {
    return ItemLinksXEntity(
        alternateOfItemLinksX = alternate?.toItemAlternateEntity() ?: ItemAlternateEntity(0, ""),
        selfOfItemLinksX = self?.toItemSelfEntity() ?: ItemSelfEntity(0, ""),
        attachmentOfItemLinksX = attachment?.toItemAlternateEntity() ?: ItemAlternateEntity(0, "")
    )
}

fun ItemLinksXEntity.toLinksX(): LinksX {
    return LinksX(
        alternate = alternateOfItemLinksX.toAlternate(),
        self = selfOfItemLinksX.toLinks(),
        attachment = alternateOfItemLinksX.toAlternate()
    )
}
