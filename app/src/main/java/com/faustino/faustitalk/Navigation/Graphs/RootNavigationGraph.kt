package com.faustino.faustitalk.Navigation.Graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faustino.faustitalk.Navigation.MainScreen
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel

@Composable
fun RootNavigationGraph() {
    val rootNavHostController = rememberNavController()
    val authViewModel = AuthViewModel()
    NavHost(
        navController = rootNavHostController,
        startDestination = Graph.AUTHENTICATION,
        route = Graph.ROOT
    ){

        composable(route = Graph.MAIN_SCREEN){
            MainScreen(rootNavHostController = rootNavHostController, authViewModel = authViewModel)
        }
        authNavGraph(rootNavHostController,authViewModel)

    }

}

object Graph{
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val MAIN_SCREEN = "main_screen_graph"
}