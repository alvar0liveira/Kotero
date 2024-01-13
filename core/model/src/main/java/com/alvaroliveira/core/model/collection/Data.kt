package com.alvaroliveira.core.model.collection


import com.alvaroliveira.core.database.entity.collection.CollectionDataEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "key")
    val key: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "parentCollection")
    val parentCollection: Boolean,
    @Json(name = "relations")
    val relations: Relations,
    @Json(name = "version")
    val version: Int
)

fun Data.toCollectionDataEntity(): CollectionDataEntity{
    return CollectionDataEntity(
        keyOfCollection = key,
        nameOfCollection = name,
        parentCollection = parentCollection,
        versionOfCollection = version
    )
}


fun CollectionDataEntity.toData(): Data{
    return Data(
        key = keyOfCollection,
        name = nameOfCollection,
        parentCollection = parentCollection,
        version = versionOfCollection,
        relations = Relations()
    )
}