package com.faustino.faustitalk.View.Auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen
import com.faustino.faustitalk.Navigation.Graphs.Graph
import com.faustino.faustitalk.R
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Components.Inputs.CustomOutlinedTextField
import com.faustino.faustitalk.ui.theme.Dark900
import com.faustino.faustitalk.ui.theme.Green300


@Composable
fun SignupScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {


    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var hiddenPasswordIcon by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated ->
                navController.navigate(Graph.MAIN_SCREEN){
                    popUpTo(AuthScreen.Login.route){inclusive = true}
                }
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message,Toast.LENGTH_SHORT).show()
            else ->Unit
        }
    }

    val icon = if (hiddenPasswordIcon) {
        painterResource(id = R.drawable.eye_open_password)
    } else {
        painterResource(id = R.drawable.eye_hidden_password)
    }
   // val authState = authViewModel.authState.observeAsState()
   // val context = LocalContext.current



    fondoLogin()
/*
    Box (
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 40.dp)
            .background(Color.Transparent)
            .clip(CircleShape)
            .clickable { }

    ){
        Icon(
            painter = painterResource(id = R.drawable.arrow_prev),
            contentDescription = "",
            modifier = Modifier.size(40.dp),
            tint = Color.White
        )

    }

*/

    Column(
        modifier = modifier
            .fillMaxSize()
            /*.background(
                Brush.verticalGradient(
                    listOf(Dark01Base, Dark02Base),
                )
            )*/
            .padding(horizontal = 32.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        /*
        Row (
            modifier = Modifier.fillMaxWidth()
        ){

            Text(text = "Fausti",
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,

                )
            Text(text = "Talk",
                fontSize = 40.sp,
                color = GreenBase,
                fontWeight = FontWeight.ExtraBold,

                )
        }*/
        Spacer(modifier = Modifier
            .height(40.dp)
        )
        Column (
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Crea una cuenta✨",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Black,

                )

            Spacer(modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
            )

            Text(text = "Introduzca sus datos personales.",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.5f),
                fontWeight = FontWeight.Normal,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column (
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Email",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            CustomOutlinedTextField(value = email, onValueChange = {email = it}, placeholder = "juan@jemplo.com")

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Contraseña",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                // label = {Text(text = "Password")},
                placeholder = { Text("Ingrese una contraseña", color = Color.White.copy(alpha = 0.5f)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)

                //.clip(RoundedCornerShape(15.dp))
                ,
                shape = RoundedCornerShape(15.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                textStyle = TextStyle(color=Color.White),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Green300, // Color del borde cuando está enfocado
                    unfocusedBorderColor = Color.Transparent, // Color del borde cuando no está enfocado
                    focusedLabelColor = Green300,
                    unfocusedContainerColor = Color.White.copy(alpha = 0.1f),
                    focusedContainerColor = Color.White.copy(alpha = 0.04f)
                ),
                trailingIcon = {
                      IconButton(
                        onClick = { hiddenPasswordIcon = !hiddenPasswordIcon },
                        modifier = Modifier.padding(end = 8.dp)) {
                        Icon(painter = icon, contentDescription = "Visible icon" )
                    }
                },
                visualTransformation = if (hiddenPasswordIcon) VisualTransformation.None
                else PasswordVisualTransformation()

            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(

                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green300
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp)

                ,
                onClick = {
                    authViewModel.signup(email,password)
                },
                //enabled = authState.value != AuthState.Loading
            ) {
                Text(
                    text = "Registrar",
                    color = Color(0xFF171520),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = {
            navController.navigate("login")
        }) {
            Text(text = "¿Ya tienes una cuenta?",
                color = Color.White)
            Text(text = "  Iniciar sesión",
                color = Green300
            )
        }

    }
}


@Composable
private fun fondoLogin(modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    0.0f to Dark900,
                    100.0f to Dark900,
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )){
        Box (
            modifier = Modifier
                .graphicsLayer {
                    translationY = -900f
                    translationX = 300f
                }

                .size(500.dp)

                .blur(radius = 300.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .clip(CircleShape)
                .background(
                    Green300.copy(alpha = 0.8f)
                    /*  brush = Brush.verticalGradient(listOf(
                        Color.Transparent,
                        GreenBase.copy(alpha = 0.6f)
                    ))*/


                )
                .align(Alignment.TopCenter)

        )

    }
}