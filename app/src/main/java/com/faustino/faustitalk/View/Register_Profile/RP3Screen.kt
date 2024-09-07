package com.faustino.faustitalk.View.Register_Profile

import MetodosViewModel
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faustino.faustitalk.R
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions
import com.faustino.faustitalk.ui.theme.Green300



@Composable
fun RP3Screen(
    modifier: Modifier,
    metodosViewModel: MetodosViewModel,
    continueClick: (tipo: Int) -> Unit = {}
) {


    var selectedProfile by remember { mutableStateOf(0) }
    var out_perfil by remember { mutableStateOf("")}
    //var errorMessage by remember { mutableStateOf<String?>(null) }

    //val isFormValid = selectedProfile


    //  BgFondoCuestion()
    Column (
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
    ){
        //Spacer(modifier = androidx.compose.ui.Modifier.padding(WindowInsets.statusBars.asPaddingValues()))
        Spacer(modifier = Modifier.height(26.dp))

        CustomTextCuestions(titulo = "Selecciona tu perfil")

        Spacer(modifier = Modifier.height(26.dp))

        btn_SelecconPerfil(
            imageResource = R.drawable.ic_estudent,
            text = "Estudiante",
            onClick = {
                        selectedProfile = 1
                        out_perfil = "Estudiante"
                      },
            selected = selectedProfile == 1
        )

        Spacer(modifier = Modifier.height(26.dp))

        btn_SelecconPerfil(
            imageResource = R.drawable.ic_book,
            text = "Docente",
            onClick = {
                        selectedProfile = 2
                        out_perfil = "Docente"
                      },
            selected = selectedProfile == 2
        )

        Spacer(modifier = Modifier.height(26.dp))

        btn_SelecconPerfil(
            imageResource = R.drawable.ic_administrative,
            text = "Administrativo",
            onClick = {
                        selectedProfile = 3
                        out_perfil = "Administrativo"
                      },
            selected = selectedProfile == 3
        )
        Spacer(modifier = Modifier.height(26.dp))

        Btn_SiguienteGreen(
            title = "Continuar",
            onClick = {
                continueClick(selectedProfile)
                metodosViewModel.completeRP3Screen(out_perfil)
            },
            enabled = selectedProfile != 0)
    }
}

@Composable
fun btn_SelecconPerfil(modifier: Modifier = Modifier, imageResource: Int , text:String,  onClick: () -> Unit, selected:Boolean) {

    /* if (selected){
            return BorderStroke(1.dp, Color.White)
            }else{
                return BorderStroke(3.dp, Green300)
            }*/
    var coloBorder  = if (selected){
        Green300
    }else{
        Color.White
    }
    var coloText = if (selected){
        Green300.copy(alpha = 0.8f)
    }else{
        Color.White
    }
    var stroke  = if (selected){
        3.dp
    }else{
        1.dp
    }


    Button(

        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(alpha = 0.05f)

        ),
        border = BorderStroke(stroke,coloBorder),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
        ,
        onClick = {
            onClick()
        },


        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = text,
                color = coloText,
                fontWeight = FontWeight.Normal,
                fontSize = 25.sp
            )
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "", modifier = Modifier.size(45.dp)
            )

        }
    }
}

