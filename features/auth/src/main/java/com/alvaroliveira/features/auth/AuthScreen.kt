package com.alvaroliveira.features.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvaroliveira.core.common.BuildConfig
import kotlinx.coroutines.launch
import java.io.File
import java.util.Properties

private val apiKey: String = BuildConfig.Zotero_Api_Key
private val userId: String = BuildConfig.Zotero_User_Id


@Composable
fun WelcomeScreen(onNavigateToLogin: () -> Unit) {

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally)  {
            Text(text = "Welcome to Kotero: An application in Android for Zotero", textAlign = TextAlign.Center)
            Text(text = "Grab your Api Key and UserId", textAlign = TextAlign.Center)
        }
        Button(onClick = onNavigateToLogin, modifier = Modifier.padding(8.dp)) {
            Text(text = "Login")
        }
    }
}

@Composable
fun LoginScreen(onNavigateToMain: (userId: String, apiKey: String) -> Unit) {
    var userId by remember {
        mutableStateOf(userId)
    }
    var apiKey by remember {
        mutableStateOf(apiKey)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        Arrangement.Top,
        Alignment.CenterHorizontally) {

        Text(text = "You can get your Api Key and UserId here: https://www.zotero.org/settings/keys")

        OutlinedTextField(
            value = userId,
            onValueChange = { userId = it },
            label = { Text("UserId") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        OutlinedTextField(
            value = apiKey,
            onValueChange = { apiKey = it },
            label = { Text("Api Key") }
        )

        Button(onClick = { onNavigateToMain(userId, apiKey) }) {
            Text(text = "Test Connection")
        }
    }
}
