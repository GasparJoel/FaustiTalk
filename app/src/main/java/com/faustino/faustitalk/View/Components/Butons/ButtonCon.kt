package com.faustino.faustitalk.View.Components.Butons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faustino.faustitalk.R
import java.lang.reflect.Modifier

@Composable
fun IconButtonWithText(
    imageResource: Int,
    buttonText: String,
    onClick: () -> Unit
) {
    Button(

        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(0.2f)
        ),
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .height(50.dp),


        onClick = onClick

        ) {

        Box (
            contentAlignment = Alignment.CenterStart
        ){

            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "",
                modifier = androidx.compose.ui.Modifier.size(28.dp)
            )

            Text(
                text = buttonText,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = androidx.compose.ui.Modifier.fillMaxWidth()
            )
        }
    }
}