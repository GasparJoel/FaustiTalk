package com.faustino.faustitalk.View.Menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.faustino.faustitalk.Navigation.Graphs.AuthScreen
import com.faustino.faustitalk.Navigation.Graphs.Graph
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.faustino.faustitalk.View.Auth.ViewModel.AuthViewModel
import com.faustino.faustitalk.ui.theme.Dark900

@Composable
fun ProfileScreen(authViewModel: AuthViewModel, navHostController: NavHostController) {


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
        Button(onClick = {
            authViewModel.signout()

        } ) {
             Text(text = "Cerrar sesión")
        }
    }
}
