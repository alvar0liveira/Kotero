package com.alvaroliveira.core.database.di

import androidx.room.Room
import com.alvaroliveira.core.database.dao.CollectionDao
import com.alvaroliveira.core.database.db.KoteroDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

var coreDatabaseModule: Module = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            KoteroDatabase::class.java,
            "koteroDatabase"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single {
        val database: KoteroDatabase = get()
        database.collectionsDao()
    }

    single {
        val database: KoteroDatabase = get()
        database.itemsDao()
    }
}