package com.faustino.faustitalk.Navigation.Graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.faustino.faustitalk.View.Auth.LoginScreen
import com.faustino.faustitalk.View.Auth.SignupScreen
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Auth.WelcomeScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController, authViewModel: AuthViewModel) {

    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Welcome.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(
                navController = navHostController,
                authViewModel = authViewModel,
                )
        }
        composable(route = AuthScreen.SignUp.route){
            SignupScreen(
                navController = navHostController,
                authViewModel = authViewModel )
        }
        composable(route = AuthScreen.Welcome.route){
            WelcomeScreen(
                navigateToLogin = { navHostController.navigate(AuthScreen.Login.route) },
                navigateToSignUp = { navHostController.navigate(AuthScreen.SignUp.route) }
            )
        }


    }

}
sealed class AuthScreen(val route:String){
    //  object SPLASH : AuthScreen("SPLASH")
    object Welcome : AuthScreen("WELCOME")
    object Login : AuthScreen("LOGIN")
    object SignUp : AuthScreen("SIGNUP")
    object Forgot : AuthScreen("FORGOT")
}