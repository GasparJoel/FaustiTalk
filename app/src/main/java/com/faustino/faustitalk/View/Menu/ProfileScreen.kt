package com.faustino.faustitalk.View.Menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue

import androidx.compose.runtime.setValue


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import androidx.room.jarjarred.org.antlr.v4.misc.Graph
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen

import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.ui.theme.Dark900

@Composable
fun ProfileScreen(authViewModel: AuthViewModel, navHostController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark900)
            .padding(horizontal = 32.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "PROFILE",
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp
        )

        // RUTA DE PRUEBA A RP1



        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Cerrar sesión") },
                text = { Text("¿Estás seguro de que deseas cerrar sesión?") },
                confirmButton = {
                    Button(onClick = {
                        showDialog = false
                        authViewModel.signout()  // Lógica de cierre de sesión

                        // Navega a la pantalla de bienvenida y limpia las rutas anteriores
                        navHostController.navigate(AuthScreen.Welcome.route) {
                            popUpTo(AuthScreen.Welcome.route) { inclusive = true }
                            launchSingleTop = true // Evita que se creen múltiples instancias de la misma pantalla
                        }
                    }) {
                        Text("Aceptar")
                    }

                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }

        Button(onClick = { showDialog = true }) {
            Text(text = "Cerrar sesión")
        }
    }
}
