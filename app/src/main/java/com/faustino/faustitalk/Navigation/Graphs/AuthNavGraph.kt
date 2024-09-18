package com.faustino.faustitalk.Navigation.Graphs

import MetodosViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.faustino.faustitalk.Navigation.RegProfileScreen
import com.faustino.faustitalk.View.Auth.LoginScreen
import com.faustino.faustitalk.View.Auth.SignupScreen
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Auth.WelcomeScreen
import com.faustino.faustitalk.View.Register_Profile.RP1Screen

fun NavGraphBuilder.authNavGraph(
    rootNavHostController: NavHostController,
    authViewModel: AuthViewModel,
    metodosViewModel: MetodosViewModel
) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Welcome.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController = rootNavHostController, authViewModel = authViewModel)
        }
        composable(route = AuthScreen.SignUp.route) {
            SignupScreen(navController = rootNavHostController, authViewModel = authViewModel)
        }
        composable(route = AuthScreen.Welcome.route) {
            WelcomeScreen(navController = rootNavHostController, authViewModel = authViewModel)
        }
        composable(route = AuthScreen.RegisterProfile.route){
            RegProfileScreen(rootNavHostController = rootNavHostController, authViewModel = authViewModel ,metodosViewModel=metodosViewModel)
        }

    }



}

sealed class AuthScreen(val route:String){
    //  object SPLASH : AuthScreen("SPLASH")
    object Welcome : AuthScreen("WELCOME")
    object Login : AuthScreen("LOGIN")
    object SignUp : AuthScreen("SIGNUP")
    object RegisterProfile : AuthScreen("REGISTERPROFILE")
    object Forgot : AuthScreen("FORGOT")
}
