package com.faustino.faustitalk.View.Components.Texts

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Text300(
    text:String
){
    Text(text = text,
        fontSize = 32.sp,
        color = Color.White,
        fontWeight = FontWeight.Black,

        )
}

@Composable
fun Text250bold(
    text:String,
    color: Color = Color.White
){
    Text(text = text,
        fontSize = 18.sp,
        color = color,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(bottom = 5.dp)
    )
}

@Composable
fun Text200bold(
    text:String,
    color: Color = Color.White
){
    Text(text = text,
        fontSize = 16.sp,
        color = color.copy(alpha = 0.9f),
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.End,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun Text200(
    text:String,
    color: Color = Color.White
){
    Text(text = text,
        fontSize = 16.sp,
        color = color.copy(alpha = 0.5f),
        fontWeight = FontWeight.Normal,
    )
}

@Composable
fun Text100(
    text:String,
    color: Color = Color.White
){
    Text(text = text,
        color = Color.White.copy(0.5f),
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        modifier = Modifier.padding(top = 8.dp)
    )
}
@Composable
fun Text101(
    text:String,
    color: Color = Color.White
){
    Text(text = text,
        color = Color.White.copy(0.9f),
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 8.dp)
    )
}