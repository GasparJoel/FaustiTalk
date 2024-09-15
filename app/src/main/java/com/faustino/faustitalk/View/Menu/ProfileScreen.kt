package com.faustino.faustitalk.View.Menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue

import androidx.compose.runtime.setValue


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen
import com.faustino.faustitalk.R

import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.ui.theme.Dark900
import com.faustino.faustitalk.ui.theme.Green300

@Composable
fun ProfileScreen(
    modifier: Modifier,
    authViewModel: AuthViewModel,
    rootNavHostController: NavHostController
) {

    var showDialog by remember { mutableStateOf(false) }



        // RUTA DE PRUEBA A RP1
        prev(modifier = modifier)


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
                Text(text = "Cerrar sesión")
            }
        }


}

@Preview
@Composable
fun prev(modifier: Modifier = Modifier) {


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Dark900)
            .padding(horizontal = 32.dp,)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        //TopBar Perfil
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
        ){
            Text(
                text = "Perfil",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                modifier = Modifier.align(Alignment.Center)
            )

            Icon(
                imageVector = Icons.Default.Menu, contentDescription = "Menu de Perfil"
                , tint = Color.White
                , modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clip(CircleShape)
                    .clickable { }
            )

        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),


        ){
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                Box(
                    modifier = Modifier
                        .size(95.dp)
                        .border(
                            BorderStroke(
                                3.dp,
                                Brush.horizontalGradient(listOf(Green300.copy(0.5f), Green300))
                            ), CircleShape
                        )
                    , contentAlignment = Alignment.Center

                )

                {
                    Image(
                        painter = painterResource(id = R.drawable.profile_user_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                }
                Text(
                    text = "@AlgunNombre",
                    color = Color.White.copy(0.6f),
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "Estudiante",
                    color = Green300,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    lineHeight = 13.sp
                  // modifier = Modifier
                )

            }
            Column(

                modifier = Modifier
                    .weight(1.5f).padding(top = 25.dp),
               // verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                Text(
                    text = "AlgunNombre",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize =20.sp,
                    modifier = Modifier
                )
                Text(
                    text = "AlgunApellidooo",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                ){

                    Box(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(Color.White.copy(0.2f))
                            .clickable { }
                            .height(32.dp)
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Text(
                            text = "Compartir",
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        )

                    }
                    Spacer(modifier = modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(Green300)
                            .clickable { }
                            .height(32.dp)
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Text(
                            text = "Editar",
                            color = Dark900,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        )

                    }


                }

            }
        }










    }
}
