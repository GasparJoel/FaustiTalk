package com.faustino.faustitalk.View.Components.Texts

import android.icu.text.CaseMap.Title
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextCuestions(
titulo : String ,
){
   Text(
       text = titulo,
       fontSize = 40.sp,
       color = Color.White,
       fontWeight = FontWeight.ExtraBold,
   )
}