package com.faustino.faustitalk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.faustino.faustitalk.Navigation.Graphs.RootNavigationGraph
import com.faustino.faustitalk.View.Register_Profile.RP3Screen
import com.faustino.faustitalk.View.Register_Profile.RP4Screen

import com.faustino.faustitalk.ui.theme.FaustiTalkTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()


        setContent {
            FaustiTalkTheme {
                RootNavigationGraph()
                //RP3Screen()
            }
        }
    }
}


//enableEdgeToEdge()
//https://developer.android.com/develop/ui/views/layout/edge-to-edge-manually?hl=es-419
//https://developer.android.com/develop/ui/views/layout/edge-to-edge?hl=es-419#kotlin

//https://www.youtube.com/watch?v=lRWGFy7IWBY Status Bar transparente y Insets en Jetpack Compose