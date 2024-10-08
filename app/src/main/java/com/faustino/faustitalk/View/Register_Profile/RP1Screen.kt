package com.faustino.faustitalk.View.Register_Profile

import MetodosViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen
import com.faustino.faustitalk.Navigation.Graphs.Graph
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen

import com.faustino.faustitalk.View.Components.Inputs.CustomOutlinedTextField
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions

//@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable

fun RP1Screen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel,
    metodosViewModel: MetodosViewModel,
    continueClick: () -> Unit = {},
) {
    // Obtener el ViewModel para manejar métodos

    // Obtener el contexto
    val context = LocalContext.current

    // Valores de los outlineText
    var out_nombre by remember { mutableStateOf("") }
    var out_apellido by remember { mutableStateOf("") }
    var out_usuario by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Observa los datos del usuario
    val userData by metodosViewModel.userData.observeAsState(emptyMap())

    // Llama a fetchUserData() para cargar los datos al inicio
    LaunchedEffect(Unit) {
        metodosViewModel.fetchUserData()
    }

    // Actualiza los valores de los campos si hay datos del usuario
    LaunchedEffect(userData) {
        out_nombre = userData["name"] as? String ?: ""
        out_apellido = userData["apellido"] as? String ?: ""
        out_usuario = userData["username"] as? String ?: ""
    }

    // Manejo del estado de autenticación
    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Authenticated ->
                navController.navigate(Graph.MAIN_SCREEN) {
                    popUpTo(AuthScreen.Login.route) { inclusive = true }
                }
            else -> Unit
        }
    }

    // Verifica si los campos están vacíos
  //  val isFormValid = out_nombre.isNotBlank() && out_apellido.isNotBlank() && out_usuario.isNotBlank()
  //  val nombreError = if (out_nombre.isBlank()) "El nombre es obligatorio" else null
  //  val apellidoError = if (out_apellido.isBlank()) "El apellido es obligatorio" else null
   // val usuarioError = if (out_usuario.isBlank()) "El nombre de usuario es obligatorio" else null
    //
  //  var isFormValid = if (out_usuario.isBlank() || out_apellido.isBlank() || out_nombre.isBlank()) false else true // detenta si un almenos un capo esta vacio
    var isFormValid  by remember { mutableStateOf(1) }

    var nombreError by remember { mutableStateOf("") }
    var apellidoError by remember { mutableStateOf("") }
    var usuarioError by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextCuestions(titulo = "¿Cuál es tu nombre?")
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomOutlinedTextField(
            value = out_nombre,
            onValueChange = { out_nombre = it },
            placeholder = "Ingrese su nombre",
            isError = out_nombre.isBlank() && isFormValid != 1,
            errorMessage = nombreError
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextCuestions(titulo = "¿Cuál es tu Apellido?")
        }

        Spacer(modifier = Modifier.height(20.dp))
        CustomOutlinedTextField(
            value = out_apellido,
            onValueChange = { out_apellido = it },
            placeholder = "Ingrese su Apellido",
            isError = out_apellido.isBlank() && isFormValid != 1,
            errorMessage = apellidoError
        )

        Spacer(modifier = Modifier.height(20.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextCuestions(titulo = "Nombre de usuario")
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomOutlinedTextField(
            value = out_usuario,
            onValueChange = { out_usuario = it },
            placeholder = "Ingrese su nombre de usuario",
            isError = out_usuario.isBlank() && isFormValid != 1,
            errorMessage = usuarioError
        )
        Spacer(modifier = Modifier.height(20.dp))


        // Botón para continuar
        Btn_SiguienteGreen(
            title = "Continuar",
            onClick = {
                if (out_usuario.isBlank() || out_apellido.isBlank() || out_nombre.isBlank()) isFormValid = 2 else isFormValid = 3
                if (isFormValid == 3) {
                    continueClick()
                    metodosViewModel.completeRP1Screen(out_nombre, out_apellido, out_usuario)
                } else {
                    errorMessage = "Todos los campos son obligatorios"
                    apellidoError = "El nombre es obligatorio"
                    nombreError = "El apellido es obligatorio"
                    usuarioError = "El usuario es Obligatorio"
                }
            },
            enabled = true
        )

        Spacer(modifier = Modifier.height(15.dp))
        Spacer(modifier = Modifier.weight(1f))
    }
}





