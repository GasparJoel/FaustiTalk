package com.faustino.faustitalk.View.Register_Profile

import MetodosViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions

@Composable
fun  RPDoc2Screen(
    modifier: Modifier = Modifier,
    metodosViewModel: MetodosViewModel = MetodosViewModel(),
    continueClick: () -> Unit = {}
) {
   // BgFondoCuestion()
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        CustomTextCuestions(titulo = "¿Cuentanos Sobre tí?")

        Spacer(modifier = Modifier.height(20.dp))



        Spacer(modifier = Modifier.height(20.dp))

       Btn_SiguienteGreen(title = "Continuar", onClick = { continueClick() }, enabled = true )

        }

}