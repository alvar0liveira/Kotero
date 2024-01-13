package com.alvaroliveira.core.database.converters

import androidx.room.TypeConverter
import com.alvaroliveira.core.database.entity.collection.CollectionAlternateEntity
import com.alvaroliveira.core.database.entity.collection.CollectionDataEntity
import com.alvaroliveira.core.database.entity.collection.CollectionEntity
import com.alvaroliveira.core.database.entity.collection.CollectionLibraryEntity
import com.alvaroliveira.core.database.entity.collection.CollectionLinksEntity
import com.alvaroliveira.core.database.entity.collection.CollectionLinksXEntity
import com.alvaroliveira.core.database.entity.collection.CollectionMetaEntity
import com.alvaroliveira.core.database.entity.collection.CollectionSelfEntity
import com.alvaroliveira.core.database.entity.collection.CollectionUpEntity
import com.alvaroliveira.core.database.entity.item.ItemAlternateEntity
import com.alvaroliveira.core.database.entity.item.ItemDataEntity
import com.alvaroliveira.core.database.entity.item.ItemEntity
import com.alvaroliveira.core.database.entity.item.ItemLibraryEntity
import com.alvaroliveira.core.database.entity.item.ItemLinksEntity
import com.alvaroliveira.core.database.entity.item.ItemLinksXEntity
import com.alvaroliveira.core.database.entity.item.ItemMetaEntity
import com.alvaroliveira.core.database.entity.item.ItemSelfEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.IllegalArgumentException
import java.lang.reflect.Type

class Converters {

    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    @TypeConverter
    fun fromCollectionAlternateEntityToJson(entity: CollectionAlternateEntity): String {
        return moshi.adapter(CollectionAlternateEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToCollectionAlternateEntity(json: String): CollectionAlternateEntity {
        return moshi
            .adapter(CollectionAlternateEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionAlternateEntity")
    }

    @TypeConverter
    fun fromCollectionDataEntityToJson(entity: CollectionDataEntity): String {
        return moshi.adapter(CollectionDataEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToCollectionDataEntity(json: String): CollectionDataEntity {
        return moshi
            .adapter(CollectionDataEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionDataEntity")
    }

    @TypeConverter
    fun fromCollectionEntityToJson(entity: CollectionEntity): String {
        return moshi.adapter(CollectionEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToCollectionEntity(json: String): CollectionEntity {
        return moshi
            .adapter(CollectionEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionEntity")
    }


    @TypeConverter
    fun fromCollectionEntityToJson(entities: List<CollectionEntity>): String {
        val type: Type = Types.newParameterizedType(List::class.java, CollectionEntity::class.java)
        val adapter = moshi.adapter<List<CollectionEntity>>(type)
        return adapter.toJson(entities)
    }

    @TypeConverter
    fun fromJsonToCollectionEntities(json: String): List<CollectionEntity> {
        val type: Type = Types.newParameterizedType(List::class.java, CollectionEntity::class.java)
        val adapter = moshi.adapter<List<CollectionEntity>>(type)
        return adapter.fromJson(json) ?: throw IllegalArgumentException("Invalid JSON CollectionEntity")
    }

    @TypeConverter
    fun fromCollectionLibraryEntityToJson(entity: CollectionLibraryEntity): String {
        return moshi.adapter(CollectionLibraryEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToCollectionLibraryEntity(json: String): CollectionLibraryEntity {
        return moshi
            .adapter(CollectionLibraryEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionLibraryEntity")
    }

    @TypeConverter
    fun fromCollectionLinksEntityToJson(entity: CollectionLinksEntity): String {
        return moshi.adapter(CollectionLinksEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToCollectionLinksEntity(json: String): CollectionLinksEntity {
        return moshi
            .adapter(CollectionLinksEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionLinksEntity")
    }

    @TypeConverter
    fun fromCollectionLinksXEntityToJson(entity: CollectionLinksXEntity): String {
        return moshi.adapter(CollectionLinksXEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToCollectionLinksXEntity(json: String): CollectionLinksXEntity {
        return moshi
            .adapter(CollectionLinksXEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionLinksXEntity")
    }

    @TypeConverter
    fun fromCollectionMetaEntityToJson(entity: CollectionMetaEntity): String {
        return moshi.adapter(CollectionMetaEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToCollectionMetaEntity(json: String): CollectionMetaEntity {
        return moshi
            .adapter(CollectionMetaEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionMetaEntity")
    }

    @TypeConverter
    fun fromCollectionSelfEntityToJson(entity: CollectionSelfEntity): String {
        return moshi.adapter(CollectionSelfEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToCollectionSelfEntityEntity(json: String): CollectionSelfEntity {
        return moshi
            .adapter(CollectionSelfEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionMetaEntity")
    }

    @TypeConverter
    fun fromCollectionUpEntityToJson(entity: CollectionUpEntity): String {
        return moshi.adapter(CollectionUpEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToCollectionUpEntity(json: String): CollectionUpEntity {
        return moshi
            .adapter(CollectionUpEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionMetaEntity")
    }


    @TypeConverter
    fun fromItemAlternateEntityToJson(entity: ItemAlternateEntity): String {
        return moshi.adapter(ItemAlternateEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToItemAlternateEntity(json: String): ItemAlternateEntity {
        return moshi
            .adapter(ItemAlternateEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionAlternateEntity")
    }

    @TypeConverter
    fun fromItemDataEntityToJson(entity: ItemDataEntity): String {
        return moshi.adapter(ItemDataEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToItemDataEntity(json: String): ItemDataEntity {
        return moshi
            .adapter(ItemDataEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionDataEntity")
    }

    @TypeConverter
    fun fromItemEntityToJson(entity: ItemEntity): String {
        return moshi.adapter(ItemEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToItemEntity(json: String): ItemEntity {
        return moshi
            .adapter(ItemEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionEntity")
    }

    @TypeConverter
    fun fromItemLibraryEntityToJson(entity: ItemLibraryEntity): String {
        return moshi.adapter(ItemLibraryEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToItemLibraryEntity(json: String): ItemLibraryEntity {
        return moshi
            .adapter(ItemLibraryEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionLibraryEntity")
    }

    @TypeConverter
    fun fromItemLinksEntityToJson(entity: ItemLinksEntity): String {
        return moshi.adapter(ItemLinksEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToItemLinksEntity(json: String): ItemLinksEntity {
        return moshi
            .adapter(ItemLinksEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON ItemLinksEntity")
    }

    @TypeConverter
    fun fromItemLinksXEntityToJson(entity: ItemLinksXEntity): String {
        return moshi.adapter(ItemLinksXEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToItemLinksXEntity(json: String): ItemLinksXEntity {
        return moshi
            .adapter(ItemLinksXEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON CollectionLinksXEntity")
    }

    @TypeConverter
    fun fromItemMetaEntityToJson(entity: ItemMetaEntity): String {
        return moshi.adapter(ItemMetaEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToItemMetaEntity(json: String): ItemMetaEntity {
        return moshi
            .adapter(ItemMetaEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON ItemMetaEntity")
    }

    @TypeConverter
    fun fromItemSelfEntityToJson(entity: ItemSelfEntity): String {
        return moshi.adapter(ItemSelfEntity::class.java).toJson(entity)
    }

    @TypeConverter
    fun fromJsonToItemSelfEntity(json: String): ItemSelfEntity {
        return moshi
            .adapter(ItemSelfEntity::class.java)
            .fromJson(json)
            ?: throw IllegalArgumentException("Invalid JSON ItemSelfEntity")
    }

}