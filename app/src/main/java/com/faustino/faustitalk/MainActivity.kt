package com.faustino.faustitalk

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.faustino.faustitalk.Navigation.Graphs.Graph
import com.faustino.faustitalk.Navigation.Graphs.RootNavigationGraph
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel

import com.faustino.faustitalk.ui.theme.FaustiTalkTheme

class MainActivity : ComponentActivity() {

    private lateinit var authViewModel: AuthViewModel
    private lateinit var splashScreen: SplashScreen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel = AuthViewModel()
        splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition {
            // Mantener el splash visible mientras el estado es "Loading"
            authViewModel.authState.value is AuthState.Loading
        }

        enableEdgeToEdge()
        setContent {

/*
            var route = Graph.AUTHENTICATION
            if(authViewModel.authState.value == AuthState.Authenticated){
                route = Graph.MAIN_SCREEN
            }*/

            FaustiTalkTheme {
                // Observa el estado de autenticación
                val authState by authViewModel.authState.observeAsState(AuthState.Loading)

                when (authState) {
                    is AuthState.Authenticated -> {
                        RootNavigationGraph(authViewModel, Graph.MAIN_SCREEN)
                    }
                    is AuthState.IncompleteProfile -> {
                        RootNavigationGraph(authViewModel, Graph.AUTHENTICATION)
                    }
                    else -> {
                        RootNavigationGraph(authViewModel, Graph.AUTHENTICATION)
                    }
                }
                //RP3Screen()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(authViewModel.authState.value == AuthState.IncompleteProfile){
           authViewModel.signout()
        }

    }


}


//enableEdgeToEdge()
//https://developer.android.com/develop/ui/views/layout/edge-to-edge-manually?hl=es-419
//https://developer.android.com/develop/ui/views/layout/edge-to-edge?hl=es-419#kotlin

//https://www.youtube.com/watch?v=lRWGFy7IWBY Status Bar transparente y Insets en Jetpack Compose