package com.faustino.faustitalk.View.Register_Profile

import MetodosViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.DropdownMenus.RegisterDropdownMenu
import com.faustino.faustitalk.View.Components.Inputs.CustomDatePicker
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions

@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun RP2Screen(
    modifier: Modifier = Modifier,
    metodosViewModel: MetodosViewModel = MetodosViewModel(),
    continueClick: () -> Unit = {}
) {

    //Valores de los outlineText
    var out_fecha_nacimiento by remember { mutableStateOf("") }
    var out_genero by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }


    val isFormValid = out_fecha_nacimiento.isNotBlank() && out_genero.isNotBlank()


    //BgFondoCuestion()
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {

        Spacer(modifier = Modifier.height(15.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTextCuestions(titulo = "Fecha de Nacimiento")
        }

        Spacer(modifier = Modifier.height(20.dp))

        CustomDatePicker()

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTextCuestions(titulo = "Género")
        }

        Spacer(modifier = Modifier.height(20.dp))

        RegisterDropdownMenu(
            generos_list,
            value = { out_genero = it })

        //Text(text = "Currentrly select : "+ genero)
        Spacer(modifier = Modifier.height(20.dp))

        Btn_SiguienteGreen(title = "Continuar",
            onClick = {
                continueClick()
                metodosViewModel.completeRP2Screen(out_fecha_nacimiento, out_genero)
            },
            enabled = true
        )

        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

    }
}


private val generos_list = listOf("SELECCIONAR","MASCULINO","FEMENINO","PREFIERO NO DECIRLO")

