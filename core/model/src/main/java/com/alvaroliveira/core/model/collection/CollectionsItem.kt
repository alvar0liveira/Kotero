package com.alvaroliveira.core.model.collection


import com.alvaroliveira.core.database.entity.collection.CollectionEntity
import com.alvaroliveira.core.model.common.Library
import com.alvaroliveira.core.model.common.toCollectionLibraryEntity
import com.alvaroliveira.core.model.common.toLibrary
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CollectionsItem(
    @Json(name = "data")
    val `data`: Data,
    @Json(name = "key")
    val key: String,
    @Json(name = "library")
    val library: Library,
    @Json(name = "links")
    val links: LinksX,
    @Json(name = "meta")
    val meta: Meta,
    @Json(name = "version")
    val version: Int
)

fun CollectionsItem.toCollectionEntity(): CollectionEntity{
    return CollectionEntity(
        keyOfCollectionEntity = key,
        dataOfCollection = data.toCollectionDataEntity(),
        library = library.toCollectionLibraryEntity(),
        linksXOfCollectionEntity = links.toCollectionLinksXEntity(),
        metaOfCollection = meta.toCollectionMetaEntity(),
        versionOfCollectionEntity = version
    )
}

fun CollectionEntity.toCollectionsItem(): CollectionsItem{
    return CollectionsItem(
        key = keyOfCollectionEntity,
        data = dataOfCollection.toData(),
        library = library.toLibrary(),
        links = linksXOfCollectionEntity.toLinksX(),
        meta = metaOfCollection.toCollectionMeta(),
        version = versionOfCollectionEntity
    )
}