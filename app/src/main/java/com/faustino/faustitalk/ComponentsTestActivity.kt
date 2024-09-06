package com.faustino.faustitalk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.faustino.faustitalk.Navigation.Graphs.RootNavigationGraph
import com.faustino.faustitalk.View.Register_Profile.RP2Screen

class ComponentsTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

       super.onCreate(savedInstanceState)
        installSplashScreen()
        //enableEdgeToEdge()
        setContent {
           // ComponentsTestScreen()
            //RootNavigationGraph()
        }
    }
}
@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun ComponentsTestScreen() {
  //  BgFondoCuestion()

    RP2Screen()
}
