package com.alvaroliveira.features.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.alvaroliveira.core.common.Graph


fun NavGraphBuilder.navMainGraph(navController: NavController, viewModel: MainViewModel) {
    navigation(
        route = Graph.MainGraph.route,
        startDestination = MainGraph.CollectionsScreen.route
    ) {
        composable(route = MainGraph.CollectionsScreen.route) {
            CollectionsScreen(viewModel = viewModel, navController)

        }

        composable(
            route = MainGraph.ItemsScreen.route + "/{collectionId}",
            arguments = listOf(navArgument("collectionId") {
                type = NavType.StringType
                nullable = false
            })
        ) {
            it.arguments?.getString("collectionId")?.let { collectionKey ->
                CollectionScreen(
                    viewModel = viewModel,
                    navController = navController,
                    collectionId = collectionKey
                )
                //ItemsList(viewModel = viewModel, onCollectionClick = {}, on)
            }
        }

        composable(route = MainGraph.ItemScreen.route + "/{collectionId}" + "/{itemKey}",
            arguments = listOf(
                navArgument(name = "collectionId") {
                    type = NavType.StringType
                    nullable = false
                },
                navArgument(name = "itemKey") {
                    type = NavType.StringType
                    nullable = false
                }
            )) {
            val collectionKey = it.arguments?.getString("collectionId").orEmpty()
            val itemKey = it.arguments?.getString("itemKey").orEmpty()

            ItemScreen(viewModel = viewModel, navController = navController, item = itemKey, collectionKey = collectionKey)
        }
    }

    composable(route = MainGraph.PDFScreen.route + "/{itemKey}" + "/{apiKey}" + "/{userId}",
        arguments = listOf(
            navArgument(name = "itemKey") {
                type = NavType.StringType
                nullable = false
            },
            navArgument(name = "apiKey") {
                type = NavType.StringType
                nullable = false
            },

            navArgument(name = "userId") {
                type = NavType.StringType
                nullable = false
            }

        )) {
        val itemKey = it.arguments?.getString("itemKey").orEmpty()
        val apiKey = it.arguments?.getString("apiKey").orEmpty()
        val userId = it.arguments?.getString("userId").orEmpty()

        PDFScreen(key = itemKey, apiKey = apiKey, userId = userId)
    }
}


sealed class MainGraph(val route: String) {
    data object CollectionsScreen : MainGraph("COLLECTIONS_SCREEN")
    data object ItemsScreen : MainGraph("ITEMS_SCREEN")
    data object ItemScreen : MainGraph("ITEM_SCREEN")
    data object PDFScreen : MainGraph("PDF_SCREEN")
}