package com.faustino.faustitalk.View.Register_Profile

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen
import com.faustino.faustitalk.Navigation.Graphs.Graph
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion

import com.faustino.faustitalk.View.Components.Inputs.CustomOutlinedTextField
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions

//@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun RP1Screen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {




    //Valores de los outlineText

    var out_nombre by remember { mutableStateOf("") }
    var out_apellido by remember { mutableStateOf("") }
    var out_usuario by remember { mutableStateOf("") }


//
    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated ->
                navController.navigate(Graph.MAIN_SCREEN){
                    popUpTo(AuthScreen.Login.route){inclusive = true}
                }
            else ->Unit
        }
    }

    BgFondoCuestion()
    Column (
        // verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),

        ){
        Spacer(modifier = androidx.compose.ui.Modifier.padding(WindowInsets.statusBars.asPaddingValues()))
        Row (
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = "Crear Perfil",
                fontSize = 22.sp,
                color = Color.White
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
        Column (

            horizontalAlignment = Alignment.CenterHorizontally,

            ){
            CustomTextCuestions(titulo = "¿Cuál es tu nombre?")

        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

         CustomOutlinedTextField(value = out_nombre, onValueChange ={ out_nombre=it} , placeholder ="Ingrese su nombre" )

        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))


        Column (

            horizontalAlignment = Alignment.CenterHorizontally,

            ){
            CustomTextCuestions(titulo = "¿Cuál es tu Apellido?")

        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

        CustomOutlinedTextField(value = out_apellido, onValueChange ={ out_apellido=it} , placeholder ="Ingrese su Apellido" )
        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

        Column (

            horizontalAlignment = Alignment.CenterHorizontally,

            ){

            CustomTextCuestions(titulo ="Nombre de usuario" )


        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

        CustomOutlinedTextField(value = out_usuario, onValueChange ={ out_usuario=it} , placeholder ="Ingrese su nombre de usuario" )
        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))


        //completa el registro  -- solo prueba
        Btn_SiguienteGreen(title = "Continuar",{ authViewModel.completeUserProfile(out_nombre,out_apellido,out_usuario) }, enabled = true)


        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

        Spacer(modifier = androidx.compose.ui.Modifier.weight(1f))

    }
}





