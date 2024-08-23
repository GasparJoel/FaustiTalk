package com.faustino.faustitalk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Inputs.CustomDatePickerField

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
//    var selectedDate by remember { mutableStateOf("") }
//
//    CustomDatePickerField(
//        label = "Select Date",
//        selectedDate = selectedDate,
//        onDateSelected = { date ->
//            selectedDate = date
//        }
//    )
}
