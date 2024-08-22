package com.faustino.faustitalk.View.Register_Profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import org.w3c.dom.Text

/*@Preview(device = "spec:width=1344px,height=2992px,dpi=480")*/
@Composable
fun RPDoc2Screen(modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier) {
    BgFondoCuestion()
    Column (
        horizontalAlignment =Alignment.Start,
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
    
        Row (
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,

        ){
            Icon(
                imageVector = Icons.Default.Person, // Puedes cambiar el ícono según tus necesidades
                contentDescription = "Icono de perfil",
                tint = Color.White,
                modifier = Modifier.size(24.dp) // Tamaño del ícono
            )

            Text(text = "Crear Perfil",
                fontSize = 22.sp,
                color = Color.White
                )
        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
    }

}