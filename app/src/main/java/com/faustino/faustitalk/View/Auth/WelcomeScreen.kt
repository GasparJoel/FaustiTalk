package com.faustino.faustitalk.View.Auth
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.faustino.faustitalk.ui.theme.Green300
import com.faustino.faustitalk.R
import com.faustino.faustitalk.View.Components.Butons.Btn_CrearCuenta
import com.faustino.faustitalk.View.Components.Butons.IconButtonWithText
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Fondos.BgFondoPrincipal

/*@Preview(device = "spec:width=1344px,height=2992px,dpi=480")*/
@Composable
fun WelcomeScreen(navigateToLogin: () -> Unit = {}, navigateToSignUp: () -> Unit = {}) {

    BgFondoPrincipal();


    Column (
        // verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),


        ){
        Spacer(modifier = Modifier.weight(2.4f))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ){
            Text(text = "Fausti",
                fontSize = 45.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,

                )
            Text(text = "Talk",
                fontSize = 45.sp,
                color = Color(0xFF76F083),
                fontWeight = FontWeight.ExtraBold,

                )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column (

            horizontalAlignment = Alignment.CenterHorizontally,

            ){
            Text(

                text = "Uniendo facultades",
                fontSize = 27.sp,
                fontWeight = FontWeight.W400,
                style = TextStyle(
                    Brush.horizontalGradient(listOf(
                        Color.White,
                        Color.White.copy(alpha = 0.5f)

                    ))
                )


            )
            Text(text = "Compartiendo momentos",
                fontSize = 27.sp,
                fontWeight = FontWeight.W400,
                style = TextStyle(
                    Brush.horizontalGradient(listOf(
                        Color.White,
                        Color.White.copy(alpha = 0.5f)

                    ))
                )
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            // modifier = Modifier.padding(horizontal = 20.dp),
            text = "Al pulsar en \"Iniciar sesión\", aceptas nuestros Términos. Descubre cómo procesamos tus datos en nuestra Política de privacidad y Política de cookies.",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            lineHeight = 14.sp
        )
        Spacer(modifier = Modifier.height(15.dp))

        Btn_CrearCuenta(titte = "Crear una cuenta")

        Spacer(modifier = Modifier.height(15.dp))

        IconButtonWithText(imageResource = R.drawable.icon_google, buttonText = "Continuar con Google") {
            
        }

        Spacer(modifier = Modifier.height(15.dp))

        IconButtonWithText(imageResource = R.drawable.icon_facebook, buttonText = "Continuar con Facebook") {

        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(

            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
            ,


            onClick = {
                navigateToLogin()
            },

            ) {

            Text(
                text = "Iniciar sesión",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),

            )

        }
        Spacer(modifier = Modifier.weight(1f))

    }

}


