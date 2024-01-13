package com.alvaroliveira.features.auth

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.alvaroliveira.core.common.Graph

fun NavGraphBuilder.navAuthGraph(navController: NavController, viewModel: AuthViewModel){
    navigation(
        route = Graph.AuthGraph.route,
        startDestination = AuthGraph.Welcome.route
    ){
        composable(route = AuthGraph.Welcome.route){
            WelcomeScreen {
                navController.navigate(AuthGraph.Login.route)
            }
        }

        composable(route = AuthGraph.Login.route){
            LoginScreen { userId, apiKey ->
                viewModel.saveUserId(userId)
                viewModel.saveApiKey(apiKey)

                navController.navigate(Graph.MainGraph.route)
            }
        }
    }
}


sealed class AuthGraph(val route: String){
    data object Welcome: AuthGraph(route = "WELCOME_SCREEN")
    data object Login: AuthGraph(route = "LOGIN_SCREEN")
}