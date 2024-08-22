package com.faustino.faustitalk.View.Components.Butons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faustino.faustitalk.ui.theme.Green300

@Composable
fun Btn_SiguienteGreen(
    titte:String
){
    Button(

        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Green300
        ),
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .height(50.dp)

        ,
        onClick = {
            //navController.navigate("signup")
        },

        ) {
        Text(
            text = titte,
            color = Color(0xFF171520),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}