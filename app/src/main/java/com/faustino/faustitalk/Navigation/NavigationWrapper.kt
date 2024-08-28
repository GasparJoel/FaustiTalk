package com.faustino.faustitalk.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faustino.faustitalk.View.Auth.LoginScreen
import com.faustino.faustitalk.View.Auth.SignupScreen
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Auth.WelcomeScreen
import com.faustino.faustitalk.View.Register_Profile.RP1Screen
import com.faustino.faustitalk.View.Register_Profile.RPDoc1Screen
import com.faustino.faustitalk.View.Register_Profile.RPUni1Screen

@Composable
fun NavigationWrapper(modifier: Modifier = Modifier, authViewModel: AuthViewModel, navController: NavController) {

    NavHost(navController = navController as NavHostController, startDestination = "welcome", builder = {

        composable("welcome") {
            WelcomeScreen(
                navigateToLogin = { navController.navigate("login") },
                navigateToSignUp = { navController.navigate("signup") }
            )
        }
        composable("login") {
            LoginScreen(modifier, navController, authViewModel)
        }

        composable("signup") {
            SignupScreen()
        }
        composable("RP1Screen") {
            RP1Screen()
        }

    })
}