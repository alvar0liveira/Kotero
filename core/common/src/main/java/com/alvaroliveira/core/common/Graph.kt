package com.alvaroliveira.core.common

sealed class Graph(val route: String){
    data object AuthGraph: Graph(route = "AUTH_GRAPH")
    data object MainGraph: Graph(route = "MAIN_GRAPH")
}
