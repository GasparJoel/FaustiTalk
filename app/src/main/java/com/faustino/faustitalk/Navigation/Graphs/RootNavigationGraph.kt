package com.faustino.faustitalk.Navigation.Graphs

import MetodosViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faustino.faustitalk.Navigation.MainScreen
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel

@Composable
fun RootNavigationGraph(authViewModel: AuthViewModel, route: String) {
    val rootNavHostController = rememberNavController()
    val metodosViewModel = MetodosViewModel()
    //val authViewModel = AuthViewModel()
    NavHost(
        navController = rootNavHostController,
        startDestination = route,
        route = Graph.ROOT
    ){

        composable(route = Graph.MAIN_SCREEN,
            enterTransition = { null },
            exitTransition = { null },
            popEnterTransition = { null },
            popExitTransition = { null }
        ){
            MainScreen(rootNavHostController = rootNavHostController, authViewModel = authViewModel ,metodosViewModel=metodosViewModel)
        }
        authNavGraph(rootNavHostController,authViewModel,metodosViewModel)
        settingsNavGraph(rootNavHostController,authViewModel)

    }

}

object Graph{
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val MAIN_SCREEN = "main_screen_graph"
    const val SETTING = "setting_screen_graph"
}