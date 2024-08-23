package com.faustino.faustitalk.View.Register_Profile

import android.app.DatePickerDialog
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.platform.LocalContext
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Inputs.CustomDatePickerField
import com.faustino.faustitalk.View.Components.Inputs.CustomOutlinedTextField
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions
import java.util.Calendar

//@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun RPDoc2Screen(modifier: Modifier = Modifier) {

    //Valores de los outlineText
    var out_fecha_nacimiento by remember { mutableStateOf("") }

    BgFondoCuestion()
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Icono de perfil",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(24.dp)
            )

            Text(
                text = "Crear Perfil",
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTextCuestions(titulo = "Fecha de Nacimiento")
        }

        Spacer(modifier = Modifier.height(20.dp))

        CustomDatePickerField(
            label = "01/01/2000",
            selectedDate = out_fecha_nacimiento,
            onDateSelected = { out_fecha_nacimiento = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTextCuestions(titulo = "Género")
        }

        Spacer(modifier = Modifier.height(20.dp))



        Spacer(modifier = Modifier.height(20.dp))

        Btn_SiguienteGreen(titte = "Continuar")

        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

    }
}