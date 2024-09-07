package com.faustino.faustitalk.View.Register_Profile

import MetodosViewModel
import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.DropdownMenus.RegisterDropdownMenu
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Inputs.CustomDatePicker
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions

@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun RP2Screen(modifier: Modifier = Modifier, continueClick: () -> Unit = {}) {
    
    //Acá se debería comenzar a recibir el ViewModel del RP anterior y no crear uno nuevo
    val metodosViewModel: MetodosViewModel = viewModel()

    val metodosViewModel: MetodosViewModel = viewModel()

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

