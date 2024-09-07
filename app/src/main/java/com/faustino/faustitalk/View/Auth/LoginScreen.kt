package com.faustino.faustitalk.View.Auth

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen
import com.faustino.faustitalk.Navigation.Graphs.Graph

import com.faustino.faustitalk.R
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Inputs.CustomOutlinedTextField
import com.faustino.faustitalk.View.Components.Texts.Text200
import com.faustino.faustitalk.View.Components.Texts.Text200bold
import com.faustino.faustitalk.View.Components.Texts.Text250bold
import com.faustino.faustitalk.View.Components.Texts.Text300
import com.faustino.faustitalk.ui.theme.Green300


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated ->
                navController.navigate(Graph.MAIN_SCREEN) {
                    popUpTo(AuthScreen.Login.route) { inclusive = true }
                }

            is AuthState.IncompleteProfile -> {
                navController.navigate(AuthScreen.RegisterProfile.route) {
                    popUpTo(AuthScreen.Login.route) { inclusive = true }
                }
            }

            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT
            ).show()

            else -> Unit
        }
    }

    var hiddenPasswordIcon by remember { mutableStateOf(false) }

    val icon = if (hiddenPasswordIcon) {
        painterResource(id = R.drawable.eye_open_password)
    } else {
        painterResource(id = R.drawable.eye_hidden_password)
    }

    BgFondoCuestion()

    Column(
        modifier = modifier
            .fillMaxSize()
            /*.background(
                Brush.verticalGradient(
                    listOf(Dark01Base, Dark02Base),
                )
            )*/
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {

        Spacer(
            modifier = Modifier
                .height(40.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text300(text = "Iniciar sesión")

            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth()
            )


            Text200(text = "Inicie sesión para continuar usando la aplicación.")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text250bold(text = "Email")

            CustomOutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Ingrese su Email"
            )


            Spacer(modifier = Modifier.height(8.dp))

            Text250bold(text = "Contraseña")

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                // label = {Text(text = "Password")},
                placeholder = {
                    Text(
                        "Ingrese su contraseña",
                        color = Color.White.copy(alpha = 0.5f)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)

                //.clip(RoundedCornerShape(15.dp))
                ,
                shape = RoundedCornerShape(15.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                textStyle = TextStyle(color = Color.White),
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
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(painter = icon, contentDescription = "Visible icon")
                    }
                },
                visualTransformation = if (hiddenPasswordIcon) VisualTransformation.None
                else PasswordVisualTransformation()

            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End,
            ) {
                TextButton(
                    onClick = {})
                {
                    Text200bold(text = "¿Olvidaste tu contraseña?")
                }
            }


            Spacer(modifier = Modifier.height(10.dp))

            Btn_SiguienteGreen(
                "Iniciar",
                onClick = { authViewModel.login(email, password) },
                enabled = authState.value != AuthState.Loading
            )

        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "¿No tienes una cuenta? ",
                color = Color.White
            )

            TextButton(onClick = {
                navController.navigate("signup")
            }) {
                Text200bold(
                    text = "Registrarse",
                    color = Green300
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

    }
}

