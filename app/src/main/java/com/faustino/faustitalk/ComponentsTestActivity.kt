package com.faustino.faustitalk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.faustino.faustitalk.Navigation.NavigationWrapper
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Inputs.CustomDatePicker
import com.faustino.faustitalk.View.Register_Profile.RP4Screen

class ComponentsTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

       super.onCreate(savedInstanceState)
        installSplashScreen()
        //enableEdgeToEdge()
        setContent {
            ComponentsTestScreen()

        }
    }
}
@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun ComponentsTestScreen() {
  //  BgFondoCuestion()

//    CustomDatePicker(
//    )
}
