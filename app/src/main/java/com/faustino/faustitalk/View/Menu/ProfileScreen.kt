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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import com.faustino.faustitalk.View.Components.Texts.Text100
import com.faustino.faustitalk.View.Components.Texts.Text101
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
                Text(text = "C errar sesión")
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
            .padding(horizontal = 16.dp,)
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
                horizontalArrangement = Arrangement.SpaceBetween

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
                    .weight(1.5f)
                    .padding(top = 25.dp),
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 1.dp),
                Arrangement.SpaceAround


        ){
            Column(
                modifier = Modifier
                    .weight(1f)
                ,verticalArrangement = Arrangement.Center, // Centrar verticalmente
                horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
            ) {
                Text100(text = "Facultad")
                Text101(text = "FIISI")

            }
            Column(
                modifier = Modifier
                    .weight(1f)
                ,verticalArrangement = Arrangement.Center, // Centrar verticalmente
                horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
            ) {
                Text100(text = "Escuela")
                Text101(text = "Ingenieria de sistemas")

            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    ,verticalArrangement = Arrangement.Center, // Centrar verticalmente
                horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente

            ) {
                Text100(text = "Ciclo")
                Text101(text = "IX")

            }
            Column(
                modifier = Modifier
                    .weight(1f)
                ,verticalArrangement = Arrangement.Center, // Centrar verticalmente
                horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
            ) {
                Text100(text = "Edad")
                Text101(text = "19 años")


            }
        }
        SectionsScreen()









    }
}
@Composable
fun SectionsScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Publicaciones", "Acerca de")

    Column {
        // Barra de pestañas
        TabRow(
            modifier = Modifier
                .background(Color.Black), // Color de fondo de la barra
            selectedTabIndex = selectedTabIndex,
            contentColor = Green300 // Color de la pestaña seleccionada
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        // Contenido que cambia según la pestaña seleccionada
        when (selectedTabIndex) {
            0 -> PublicacionesContent()  // Contenido de la primera pestaña
            1 -> AcercaDeContent()       // Contenido de la segunda pestaña
        }
    }
}

@Composable
fun PublicacionesContent() {
    // Aquí agregas el contenido de "Publicaciones"
    Text(
        text = "Contenido de Publicaciones",
        color = Color.White
    )
}

@Composable
fun AcercaDeContent() {
    // Aquí agregas el contenido de "Acerca de"
    Column {
        Text(
            text = "Los estudiantes tienen acceso a herramientas de aprendizaje, recursos académicos...",
            color = Color.White
        )

        // Título de "Me gusta"
        Text(
            text = "Me gusta..",
            color = Color.White,

        )

        // Botones o secciones de intereses
        Row {
            Button(onClick = { /* Acción */ }) {
                Text("⚽ Entrenar")
            }
            Button(onClick = { /* Acción */ }) {
                Text("⚽ Música")
            }
        }
        Row {
            Button(onClick = { /* Acción */ }) {
                Text("⚽ Cantar")
            }
            Button(onClick = { /* Acción */ }) {
                Text("⚽ Tomar café")
            }
        }
    }
}
