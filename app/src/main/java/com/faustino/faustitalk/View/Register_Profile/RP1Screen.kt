package com.faustino.faustitalk.View.Register_Profile

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faustino.faustitalk.R
import com.faustino.faustitalk.ui.theme.Green300
import java.lang.reflect.Modifier

@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun RPDoc1Screen(modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier) {

    Fondo()
    Column (
        // verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),


        ){
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
        Row (
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ){
            Text(text = "Crear Perfil",
                fontSize = 20.sp,
                color = Color.White
                )

        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
        Column (

            horizontalAlignment = Alignment.CenterHorizontally,

            ){
            Text(

                text = "¿Cuál es tu nombre?",
                fontSize = 27.sp,
                fontWeight = FontWeight.W400,



            )

        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(40.dp))
        Text(
            // modifier = Modifier.padding(horizontal = 20.dp),
            text = "Al pulsar en \"Iniciar sesión\", aceptas nuestros Términos. Descubre cómo procesamos tus datos en nuestra Política de privacidad y Política de cookies.",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            lineHeight = 14.sp


        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
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
                text = "Crear una cuenta",
                color = Color(0xFF171520),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
        Button(

            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White.copy(0.2f)
            ),
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(50.dp),


            onClick = {

            },

            ) {

            Box (
                contentAlignment = Alignment.CenterStart
            ){

                Image(
                    painter = painterResource(id = R.drawable.icon_google),
                    contentDescription = "",
                    modifier = androidx.compose.ui.Modifier.size(28.dp)
                )

                Text(
                    text = "Continuar con Google",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = androidx.compose.ui.Modifier.fillMaxWidth()
                )
            }
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
        Button(

            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White.copy(0.2f)
            ),
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(50.dp)
            ,


            onClick = {

            },

            ) {

            Box (
                contentAlignment = Alignment.CenterStart
            ){
                Image(
                    painter = painterResource(id = R.drawable.icon_facebook),
                    contentDescription = "",
                    modifier = androidx.compose.ui.Modifier.size(29.dp)
                )

                Text(
                    text = "Continuar con Facebook",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = androidx.compose.ui.Modifier.fillMaxWidth()
                )
            }
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
        Button(

            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(50.dp)
            ,


            onClick = {
                // navController.navigate("login")
            },

            ) {

            Text(
                text = "Iniciar sesión",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = androidx.compose.ui.Modifier.fillMaxWidth()
            )

        }
        Spacer(modifier = androidx.compose.ui.Modifier.weight(1f))

    }
}

@Composable
private fun Fondo(modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier) {
    Box (
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    0.0f to Color(0xFF171520),
                    100.0f to Color(0xFF171520),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )){
        Box (
            modifier = androidx.compose.ui.Modifier
                .graphicsLayer {
                    translationY = -800f
                }

                .size(500.dp)

                .blur(radius = 300.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .clip(CircleShape)
                .background(
                    Color(0xFF76F083).copy(alpha = 0.8f)
                    /*  brush = Brush.verticalGradient(listOf(
                        Color.Transparent,
                        GreenBase.copy(alpha = 0.6f)
                    ))*/


                )
                .align(Alignment.TopCenter)

        )

    }
}