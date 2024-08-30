package com.faustino.faustitalk.View.Register_Profile

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
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Inputs.CustomDatePicker
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions

@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun RP2Screen(modifier: Modifier = Modifier) {

    //Valores de los outlineText
    var out_fecha_nacimiento by remember { mutableStateOf("") }

    BgFondoCuestion()
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(25.dp))

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
                    .size(45.dp)
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

        CustomDatePicker(
//            label = "01/01/2000",
//            selectedDate = out_fecha_nacimiento,
//            onDateSelected = { out_fecha_nacimiento = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTextCuestions(titulo = "Género")
        }

        Spacer(modifier = Modifier.height(20.dp))

        MenuGenero()

        Spacer(modifier = Modifier.height(25.dp))

        Btn_SiguienteGreen(title = "Continuar", onClick = {},enabled = true)

        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuGenero(){
     val list = listOf("FEMENINO","MASCULINO");
    var selectText by remember {
        mutableStateOf(list[0])
    }

    var isExpanded by remember{
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(
        expanded =isExpanded ,
        onExpandedChange = {isExpanded=!isExpanded},
                modifier = Modifier.background(Color.White.copy(alpha = 0.04f), RoundedCornerShape(15.dp))
                    .border(1.dp, Color.Transparent, RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(25.dp))
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            value = selectText,
            onValueChange ={},
            readOnly = true,
            trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded=false }


        ) {
            list.forEachIndexed{index,text ->
                DropdownMenuItem(
                    text = { Text(text = text) },
                    onClick = { selectText=list[index]
                    isExpanded=false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding

                )
            }
        }
    }
    //Text(text = "Currentrly select : "+ selectText)
}