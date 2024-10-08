package com.faustino.faustitalk.Navigation

import MetodosViewModel
import android.app.AlertDialog
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentTransitionScope


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen
import com.faustino.faustitalk.Navigation.Graphs.Graph
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Register_Profile.RP1Screen
import com.faustino.faustitalk.View.Register_Profile.RP2Screen
import com.faustino.faustitalk.View.Register_Profile.RP3Screen
import com.faustino.faustitalk.View.Register_Profile.RP4Screen
import com.faustino.faustitalk.View.Register_Profile.RPDoc1Screen
import com.faustino.faustitalk.View.Register_Profile.RPDoc2Screen
import com.faustino.faustitalk.View.Register_Profile.RPUni1Screen
import com.faustino.faustitalk.ui.theme.Green300

@Composable
fun RegProfileScreen(
    rpNavHostController: NavHostController = rememberNavController(),
     rootNavHostController: NavHostController,
     authViewModel: AuthViewModel,
     metodosViewModel: MetodosViewModel
) {

   // var metodosViewModel = MetodosViewModel()

    var progress by remember { mutableStateOf(0.16f) }
    var rp1estate by remember { mutableStateOf(true) }

    var showDialog by remember { mutableStateOf(false) }

    Scaffold (
        topBar ={CustomTopAppBar(
            progress,
            navController = rpNavHostController ,
            onBackPress = {
                val currentRoute = rpNavHostController.currentBackStackEntry?.destination?.route

                if (currentRoute == RegisterProfile.RP1.route) {
                    if (showDialog) {
                        showDialog = false
                    } else {
                        showDialog = true
                    }

                }else{
                    progress -= 0.16f
                    rpNavHostController.popBackStack()
                }
            })
        } ,
        modifier = Modifier.fillMaxSize()
    ){  paddingValues ->
        BgFondoCuestion()
        var modifier = Modifier.padding(paddingValues)

        NavHost(navController = rpNavHostController,
            startDestination = RegisterProfile.RP1.route ,
            route = AuthScreen.RegisterProfile.route
            , modifier = Modifier
        ){

            composable(route = RegisterProfile.RP1.route ,
                enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            } ){
                RP1Screen(navController = rpNavHostController, authViewModel = authViewModel, modifier = modifier , metodosViewModel = metodosViewModel){
                    rpNavHostController.navigate(RegisterProfile.RP2.route){
                      //  popUpTo(RegisterProfile.RP1.route){ inclusive = true}
                        progress += 0.16f
                        rp1estate = false
                    }
                }
                BackHandler {
                  //  progress -= 0.16f

                    if (rp1estate){
                        if (showDialog) {
                            // Si ya se muestra el diálogo, no realizar la navegación hacia atrás
                            showDialog = false
                        } else {
                            // Mostrar el diálogo cuando se presiona el botón de retroceso
                            showDialog = true
                        }

                    }
                     // Volver a la pantalla anterior
                }

                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Cancelar Registro") },
                        text = { Text("¿Estás seguro de que deseas cancelar el registro de tu perfil?") },
                        confirmButton = {
                            Button(onClick = {
                                showDialog = false
                                authViewModel.signout()  // Lógica de cierre de sesión

                                // Navegar a la pantalla de bienvenida y limpiar las rutas anteriores
                                rootNavHostController.navigate(AuthScreen.Welcome.route) {
                                    popUpTo(AuthScreen.RegisterProfile.route) { inclusive = true }
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
            }
            composable(route = RegisterProfile.RP2.route,
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }, popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }

            ){
                RP2Screen(metodosViewModel = metodosViewModel,modifier = modifier, ){
                    rpNavHostController.navigate(RegisterProfile.RP3.route){
                       // popUpTo(RegisterProfile.RP2.route){ inclusive = true}
                        progress += 0.16f
                    }
                }
                BackHandler {
                    progress -= 0.16f
                    rp1estate = true
                    rpNavHostController.popBackStack() // Volver a la pantalla anterior
                }
            }
            composable(route = RegisterProfile.RP3.route,
                enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, exitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, popEnterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }
            ){

                RP3Screen( modifier = modifier ,metodosViewModel = metodosViewModel){

                    when(it){
                        1 -> rpNavHostController.navigate(RegisterProfile.RPUni1.route)
                        2 -> rpNavHostController.navigate(RegisterProfile.RPDoc1.route)
                        3 -> rpNavHostController.navigate(RegisterProfile.RPDoc1.route)

                    }
                    progress += 0.16f

                }
                BackHandler {
                    progress -= 0.16f
                    rpNavHostController.popBackStack() // Volver a la pantalla anterior
                }
            }
            //SCREEN FINAL
            composable(route = RegisterProfile.RP4.route,
                enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, exitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, popEnterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }
            ){
                RP4Screen( modifier = modifier , metodosViewModel = metodosViewModel){
                    rootNavHostController.navigate(Graph.MAIN_SCREEN){
                        progress += 0.16f   //

                        //Completar la coleccion
                    }
                }
                BackHandler {
                    progress -= 0.16f
                    rpNavHostController.popBackStack() // Volver a la pantalla anterior
                }
            }
            composable(route = RegisterProfile.RPDoc1.route,
                enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, exitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, popEnterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }
            ){
                RPDoc1Screen( modifier = modifier,metodosViewModel = metodosViewModel){
                    rpNavHostController.navigate(RegisterProfile.RPDoc2.route){
                        progress += 0.16f
                    }
                }
                BackHandler {
                    progress -= 0.16f
                    rpNavHostController.popBackStack()
                }
            }
            composable(route = RegisterProfile.RPDoc2.route,
                enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, exitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, popEnterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }
            ){
                RPDoc2Screen( modifier = modifier,metodosViewModel = metodosViewModel){
                    rpNavHostController.navigate(RegisterProfile.RP4.route){
                        progress += 0.16f
                    }
                }
                BackHandler {
                    progress -= 0.16f
                    rpNavHostController.popBackStack()
                }
            }
            composable(route = RegisterProfile.RPUni1.route,
                enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, exitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }, popEnterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }
            ){
                RPUni1Screen( modifier = modifier, metodosViewModel = metodosViewModel){
                    rpNavHostController.navigate(RegisterProfile.RPDoc2.route){
                        progress += 0.16f
                    }


                }
                BackHandler {
                    progress -= 0.16f
                    rpNavHostController.popBackStack()
                }

            }

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    //value: (String) -> Unit
    progress: Float,
    navController: NavHostController,
    onBackPress: () -> Unit
) {

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
        label = "progress"
    )

    Column( modifier = Modifier.systemBarsPadding()) {
        Row (
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 10.dp)
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Box(
                    modifier = Modifier.clip(CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Icono de perfil",

                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .size(42.dp)
                            .clickable { // Aquí se maneja el evento de retroceso
                                onBackPress() // Llama a la función de retroceso proporcionada
                                //  navController.popBackStack()
                            }

                    )
                }

                Text(
                    text = "Crear Perfil",
                    fontSize = 25.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        LinearProgressIndicator(
            progress = { animatedProgress },
            modifier = Modifier.fillMaxWidth(),
            color = Green300,
            trackColor = Color.White.copy(alpha = 0.4f),
        )

    }

}

sealed class RegisterProfile(val route:String){
    //  object SPLASH : AuthScreen("SPLASH")
    object RP1 : RegisterProfile("RP1")
    object RP2 : RegisterProfile("RP2")
    object RP3 : RegisterProfile("RP3")
    object RP4 : RegisterProfile("RP4")
    object RPDoc1 : RegisterProfile("RPDoc1")
    object RPDoc2 : RegisterProfile("RPDoc2")
    object RPUni1 : RegisterProfile("RPUni1")
    object RPUni2 : RegisterProfile("RPUni2")

}