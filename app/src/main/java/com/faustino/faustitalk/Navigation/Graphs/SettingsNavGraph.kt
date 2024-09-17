package com.faustino.faustitalk.Navigation.Graphs

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Menu.Profile.Ajustes_Privacidad

fun NavGraphBuilder.settingsNavGraph(
    rootNavHostController: NavHostController,
    authViewModel: AuthViewModel
) {
    navigation(
        route = Graph.SETTING,
        startDestination = SettingsScreen.Settings.route
    ) {
        composable(route = SettingsScreen.Settings.route,
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(150)
                )
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(150)
                )
            }) {
            Ajustes_Privacidad(modifier = Modifier, rootNavHostController = rootNavHostController, authViewModel = authViewModel)
        }

    }
}
sealed class SettingsScreen(val route:String){
    object Settings : AuthScreen("SETTING")

}
