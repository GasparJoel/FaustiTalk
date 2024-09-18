package com.faustino.faustitalk.Navigation.Graphs

import MetodosViewModel
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.faustino.faustitalk.Navigation.BottonBarScreen
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Menu.HomeScreen
import com.faustino.faustitalk.View.Menu.InboxScreen
import com.faustino.faustitalk.View.Menu.PostScreen
import com.faustino.faustitalk.View.Menu.ProfileScreen
import com.faustino.faustitalk.View.Menu.SearchScreen

@Composable
fun MainNavGraph(
    homeNavHostController: NavHostController,
    rootNavHostController: NavHostController,
    authViewModel: AuthViewModel,
    metodosViewModel:MetodosViewModel,
    modifier: Modifier
) {

    NavHost(
        navController = homeNavHostController,
        startDestination = BottonBarScreen.Home.route,
        route = Graph.MAIN_SCREEN
    ) {
        composable(
            route = BottonBarScreen.Home.route,
            enterTransition = { fadeIn(animationSpec = tween(0)) },  // Sin animación
            exitTransition = { fadeOut(animationSpec = tween(0)) },  // Sin animación
            popEnterTransition = { fadeIn(animationSpec = tween(0)) },
            popExitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            HomeScreen()
        }
        composable(
            route = BottonBarScreen.Inbox.route,
            enterTransition = { fadeIn(animationSpec = tween(0)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) },
            popEnterTransition = { fadeIn(animationSpec = tween(0)) },
            popExitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            InboxScreen()
        }
        composable(
            route = BottonBarScreen.Post.route,
            enterTransition = { fadeIn(animationSpec = tween(0)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) },
            popEnterTransition = { fadeIn(animationSpec = tween(0)) },
            popExitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            PostScreen()
        }
        composable(
            route = BottonBarScreen.Profile.route,
            enterTransition = { fadeIn(animationSpec = tween(0)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) },
            popEnterTransition = { fadeIn(animationSpec = tween(0)) },
            popExitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            ProfileScreen(modifier, authViewModel, rootNavHostController,metodosViewModel)
        }
        composable(
            route = BottonBarScreen.Search.route,
            enterTransition = { fadeIn(animationSpec = tween(0)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) },
            popEnterTransition = { fadeIn(animationSpec = tween(0)) },
            popExitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            SearchScreen()
        }
    }
}


