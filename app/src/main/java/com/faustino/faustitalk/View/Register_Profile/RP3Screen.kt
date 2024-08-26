package com.faustino.faustitalk.View.Register_Profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faustino.faustitalk.R
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions



//@Preview
@Composable
fun RP3Screen(modifier: Modifier = Modifier) {
    BgFondoCuestion()
    Column (
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
    ){
        Spacer(modifier = Modifier.height(28.dp))
        CustomTextCuestions(titulo = "Selecciona tu perfil")
        Spacer(modifier = Modifier.height(26.dp))
        btn_SelecconPerfil(imageResource = R.drawable.ic_estudent,text = "Estudiante", onClick = {})
        Spacer(modifier = Modifier.height(26.dp))
        btn_SelecconPerfil(imageResource = R.drawable.ic_book,text = "Docente", onClick = {})
        Spacer(modifier = Modifier.height(26.dp))
        btn_SelecconPerfil(imageResource = R.drawable.ic_administrative,text = "Administrativo", onClick = {})

    }

}

@Composable
fun btn_SelecconPerfil(modifier: Modifier = Modifier, imageResource: Int , text:String,  onClick: () -> Unit) {

    Button(

        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(alpha = 0.10f)

        ),
        border = BorderStroke(1.dp, Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
        ,
        onClick = {
            onClick()
        },


        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = text,
                color = Color.White.copy(alpha = 0.9f),
                fontWeight = FontWeight.Normal,
                fontSize = 25.sp
            )
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "", modifier = Modifier.size(45.dp)
            )

        }
    }
}

