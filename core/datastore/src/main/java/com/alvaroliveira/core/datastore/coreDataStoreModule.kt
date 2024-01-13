package com.alvaroliveira.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "KoteroPreferences")

val coreDataStoreModule: Module = module {
    single {
        AppDataStore(androidContext().dataStore)
    }
}