package com.faustino.faustitalk.View.Menu.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen
import com.faustino.faustitalk.Navigation.Graphs.Graph
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.ui.theme.Dark900

//@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun Ajustes_Privacidad(
    modifier: Modifier,
    rootNavHostController: NavHostController,
    authViewModel: AuthViewModel
)  {
    Box (modifier = Modifier.fillMaxSize().background(Dark900) )

    Column(

        modifier = modifier
            .systemBarsPadding()
            .background(Dark900)
            .fillMaxSize()
            .padding(horizontal = 32.dp),
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
        ){
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Icono",

                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(42.dp)
                    .clickable {
                        rootNavHostController.popBackStack()
                    }

            )
            Text(
                text = "Ajustes y privacidad",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        var showDialog by remember { mutableStateOf(false) }

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
                        rootNavHostController.navigate(AuthScreen.Welcome.route) {
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
        Column {
            Button(onClick = { showDialog = true }) {
                Text(text = "C errar sesión")
            }
        }

    }

}