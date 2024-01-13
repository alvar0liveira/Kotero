package com.alvaroliveira.core.datastore


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext


private val USERID = stringPreferencesKey("userId")
private val APIKEY = stringPreferencesKey("apiKey")

class AppDataStore(private val dataStore: DataStore<Preferences>) {

    private val coroutineScope: CoroutineScope = CoroutineScope(EmptyCoroutineContext)

    init {
        coroutineScope.launch {
            dataStore.data.first()
        }
    }

    val savedUserId: Flow<String> = dataStore.data.map { preferences ->
        preferences[USERID].orEmpty()
    }

    val savedApiKey: Flow<String> = dataStore.data.map { preferences ->
        preferences[APIKEY].orEmpty()
    }

    suspend fun flush(){
        dataStore.edit {
            it.clear()
        }
    }

    suspend fun saveUserId(text: String){
        dataStore.edit {
            it[USERID] = text
        }

    }

    suspend fun saveApiKey(text: String){
        dataStore.edit {
            it[APIKEY] = text
        }

    }

    fun getUserId(): Flow<String>{
        return dataStore.data.map {
            it[USERID] ?: ""
        }
    }
}