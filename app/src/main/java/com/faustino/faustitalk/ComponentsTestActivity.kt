package com.faustino.faustitalk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Inputs.CustomDatePicker

class ComponentsTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsTestScreen()
        }
    }
}
@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun ComponentsTestScreen() {
    BgFondoCuestion()

//    CustomDatePicker(
//    )
}
