package com.faustino.faustitalk.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faustino.faustitalk.View.Auth.LoginScreen
import com.faustino.faustitalk.View.Auth.SignupScreen
import com.faustino.faustitalk.View.Auth.WelcomeScreen


@Composable
fun NavigationWrapper(modifier: Modifier,navHostController: NavHostController) {


    NavHost(navController = navHostController, startDestination = "welcome", builder = {

        composable("welcome"){
            WelcomeScreen(
                navigateToLogin = { navHostController.navigate("login")},
                navigateToSignUp = { navHostController.navigate("signup")}
            )
        }
        composable("login"){
            LoginScreen()
        }

        composable("signup"){
            SignupScreen()
        }

    })
}