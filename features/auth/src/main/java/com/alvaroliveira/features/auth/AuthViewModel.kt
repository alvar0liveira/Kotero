package com.alvaroliveira.features.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvaroliveira.core.datastore.AppDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class AuthViewModel(
    private val appDataStore: AppDataStore
): ViewModel() {

    val userId: MutableStateFlow<String?> = MutableStateFlow(null)

    init {
        appDataStore.savedUserId
            .map {
                userId.value = it
            }
    }




    fun saveApiKey(apiKey: String){
        viewModelScope.launch {
            appDataStore.saveApiKey(apiKey)
        }
    }

    fun saveUserId(userId: String) {
        viewModelScope.launch {
            appDataStore.saveUserId(userId)
        }
    }
}