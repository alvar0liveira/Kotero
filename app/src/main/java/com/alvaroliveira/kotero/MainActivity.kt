package com.alvaroliveira.kotero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alvaroliveira.core.common.Graph
import com.alvaroliveira.core.ui.theme.KoteroTheme
import com.alvaroliveira.features.auth.AuthViewModel
import com.alvaroliveira.features.auth.navAuthGraph
import com.alvaroliveira.features.main.MainViewModel
import com.alvaroliveira.features.main.navMainGraph
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by inject()
    private val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoteroApp(
                authViewModel,
                mainViewModel
            )
        }
    }
}

@Composable
fun KoteroApp(
    authViewModel: AuthViewModel,
    mainViewModel: MainViewModel
) {
    KoteroTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            AppNavigation(
                navController = navController,
                authViewModel = authViewModel,
                mainViewModel = mainViewModel
            )
        }
    }
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    mainViewModel: MainViewModel
) {
    NavHost(navController = navController, startDestination = Graph.AuthGraph.route){
        navAuthGraph(navController, authViewModel)
        navMainGraph(navController, mainViewModel)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoteroTheme {

    }
}