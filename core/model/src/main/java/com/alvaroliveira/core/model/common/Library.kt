package com.alvaroliveira.core.model.common


import com.alvaroliveira.core.database.entity.collection.CollectionLibraryEntity
import com.alvaroliveira.core.database.entity.item.ItemLibraryEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Library(
    @Json(name = "id")
    val id: Int,
    @Json(name = "links")
    val links: Links,
    @Json(name = "name")
    val name: String,
    @Json(name = "type")
    val type: String
)

fun Library.toCollectionLibraryEntity(): CollectionLibraryEntity {
    return CollectionLibraryEntity(
        idOfCollectionLibrary = id.toLong(),
        linksOfCollectionLibrary = links.toCollectionLinksEntity(),
        nameOfCollectionLibrary = name,
        typeOfCollectionLibrary = type,
    )
}

fun Library.toItemLibraryEntity(): ItemLibraryEntity {
    return ItemLibraryEntity(
        idOfItemLibrary = id.toLong(),
        linksOfItemLibrary = links.toItemLinksEntity(),
        nameOfItemLibrary = name,
        typeOfItemLibrary = type
    )
}

fun CollectionLibraryEntity.toLibrary(): Library {
    return Library(
        id = idOfCollectionLibrary.toInt(),
        links = linksOfCollectionLibrary.toLinks(),
        name = nameOfCollectionLibrary,
        type = typeOfCollectionLibrary
    )
}

fun ItemLibraryEntity.toLibrary(): Library {
    return Library(
        id = idOfItemLibrary.toInt(),
        links = linksOfItemLibrary.toLinks(),
        name = nameOfItemLibrary,
        type = typeOfItemLibrary
    )
}