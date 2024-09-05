package com.faustino.faustitalk.View.Register_Profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.DropdownMenus.RegisterDropdownMenu
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions

@Preview
@Composable
fun RPDoc1Screen(modifier: Modifier = Modifier, continueClick: () -> Unit={}) {

    var espaciality by remember { mutableStateOf("") }
   // BgFondoCuestion()
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextCuestions(titulo = "Especialidad")
        Spacer(modifier = Modifier.height(20.dp))

        RegisterDropdownMenu(list = listOf("SELECCIONAR"), value = {espaciality = it} )

        Spacer(modifier = Modifier.height(20.dp))

        Btn_SiguienteGreen(title = "Continuar", onClick = { continueClick() }, enabled = true )


    }

}