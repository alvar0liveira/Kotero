package com.alvaroliveira.core.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.alvaroliveira.core.database.converters.Converters
import com.alvaroliveira.core.database.dao.CollectionDao
import com.alvaroliveira.core.database.dao.ItemDao
import com.alvaroliveira.core.database.entity.collection.CollectionAlternateEntity
import com.alvaroliveira.core.database.entity.collection.CollectionDataEntity
import com.alvaroliveira.core.database.entity.collection.CollectionEntity
import com.alvaroliveira.core.database.entity.collection.CollectionLibraryEntity
import com.alvaroliveira.core.database.entity.collection.CollectionLinksEntity
import com.alvaroliveira.core.database.entity.collection.CollectionLinksXEntity
import com.alvaroliveira.core.database.entity.collection.CollectionMetaEntity
import com.alvaroliveira.core.database.entity.collection.CollectionSelfEntity
import com.alvaroliveira.core.database.entity.item.ItemAlternateEntity
import com.alvaroliveira.core.database.entity.item.ItemDataEntity
import com.alvaroliveira.core.database.entity.item.ItemEntity
import com.alvaroliveira.core.database.entity.item.ItemLibraryEntity
import com.alvaroliveira.core.database.entity.item.ItemLinksEntity
import com.alvaroliveira.core.database.entity.item.ItemLinksXEntity
import com.alvaroliveira.core.database.entity.item.ItemMetaEntity
import com.alvaroliveira.core.database.entity.item.ItemSelfEntity
import com.alvaroliveira.core.database.entity.item.ItemTagEntity

@Database(
    entities = [
        CollectionAlternateEntity::class,
        CollectionDataEntity::class,
        CollectionEntity::class,
        CollectionLibraryEntity::class,
        CollectionLinksEntity::class,
        CollectionLinksXEntity::class,
        CollectionMetaEntity::class,
        CollectionSelfEntity::class,
        ItemAlternateEntity::class,
        ItemDataEntity::class,
        ItemEntity::class,
        ItemLibraryEntity::class,
        ItemLinksEntity::class,
        ItemLinksXEntity::class,
        ItemMetaEntity::class,
        ItemSelfEntity::class,
        ItemTagEntity::class
    ],
    version = 5,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class KoteroDatabase: RoomDatabase() {

    abstract fun collectionsDao(): CollectionDao
    abstract fun itemsDao(): ItemDao
}