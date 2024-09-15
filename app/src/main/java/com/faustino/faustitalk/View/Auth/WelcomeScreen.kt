package com.faustino.faustitalk.View.Auth

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.contentValuesOf
import androidx.navigation.NavHostController
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen
import com.faustino.faustitalk.Navigation.Graphs.Graph
import com.faustino.faustitalk.R
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Auth.ViewModel.WEB_CLIENT_ID
import com.faustino.faustitalk.View.Components.Butons.Btn_CrearCuenta
import com.faustino.faustitalk.View.Components.Butons.IconButtonWithText
import com.faustino.faustitalk.View.Components.Fondos.BgFondoPrincipal
import com.faustino.faustitalk.View.Components.Privacity.PrivacyPolicy
import com.faustino.faustitalk.ui.theme.Green300
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

//@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun WelcomeScreen(
    authViewModel: AuthViewModel,
    navController: NavHostController
) {

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    //--------------------------
    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated ->
                navController.navigate(Graph.MAIN_SCREEN) {
                    popUpTo(AuthScreen.Welcome.route) { inclusive = true }
                }

            is AuthState.IncompleteProfile -> {
                navController.navigate(AuthScreen.RegisterProfile.route) {
                    popUpTo(AuthScreen.Welcome.route) { inclusive = true }
                }
            }

            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT
            ).show()

            else -> Unit
        }
    }



    BgFondoPrincipal();

    Column(
        // verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),


        ) {
        Spacer(modifier = Modifier.weight(2.4f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Fausti",
                fontSize = 45.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,

                )
            Text(
                text = "Talk",
                fontSize = 45.sp,
                color = Color(0xFF76F083),
                fontWeight = FontWeight.ExtraBold,

                )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(

                text = "Uniendo facultades",
                fontSize = 27.sp,
                fontWeight = FontWeight.W400,
                style = TextStyle(
                    Brush.horizontalGradient(
                        listOf(
                            Color.White,
                            Color.White.copy(alpha = 0.5f)

                        )
                    )
                )


            )
            Text(
                text = "Compartiendo momentos",
                fontSize = 27.sp,
                fontWeight = FontWeight.W400,
                style = TextStyle(
                    Brush.horizontalGradient(
                        listOf(
                            Color.White,
                            Color.White.copy(alpha = 0.5f)

                        )
                    )
                )
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        var showDialog by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,  // Alinea el contenido horizontalmente en el centro
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(0.dp)  // Elimina padding adicional
            ) {
                Text(
                    text = "¡Bienvenido a nuestra comunidad universitaria! Recuerda que al utilizar esta app, aceptas nuestros ",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    lineHeight = 12.sp,  // Ajusta la altura de línea para evitar espacio extra
                    modifier = Modifier
                        .padding(0.dp)  // Elimina padding adicional
                )

                TextButton(
                    modifier = Modifier
                        .padding(0.dp)
                        .offset(y = -17.dp)
                        .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                        .then(Modifier.minimumInteractiveComponentSize()),
                    onClick = { showDialog = true },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Términos y Condiciones y Política de Privacidad.",
                        fontSize = 12.sp,
                        color = Green300,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .padding(0.dp)
                            .align(Alignment.CenterVertically),
                        maxLines = 1,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        PrivacyPolicy(
            showDialog = showDialog,
            onDismiss = { showDialog = false },
            onAccept = { /*VACIO, YA QUE AQUI NO SE NECESITA ACEPTAR LOS TERMINOS Y CONDICIONES Y POLÍTICA DE PRIVACIDAD,
                            EN CASO SE UTILICE... AQUI VA QUE HACE LUEGO DE ACEPTAR, EN CASO DE SOLO CERRAR EL DIALOG: showDialog = false */
            },
            showButtonsAndCheckbox = false //NO SE MUESTRAN LOS BOTONES DE ACEPTAR O NEGAR, false ocutar, true mostrar
        )

        Spacer(modifier = Modifier.height(15.dp))

        Btn_CrearCuenta(
            titte = "Crear una cuenta",
            onClick = { navController.navigate(AuthScreen.SignUp.route) })

        Spacer(modifier = Modifier.height(15.dp))

        IconButtonWithText(
            imageResource = R.drawable.icon_google,
            buttonText = "Continuar con Google"
        ) {

            authViewModel.LoginToGoogle(
                context = context,
                scope = scope
            )

        }

        Spacer(modifier = Modifier.height(15.dp))

        IconButtonWithText(
            imageResource = R.drawable.icon_facebook,
            buttonText = "Continuar con Facebook"
        ) {

        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(

            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),


            onClick = {
                navController.navigate(AuthScreen.Login.route)
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


