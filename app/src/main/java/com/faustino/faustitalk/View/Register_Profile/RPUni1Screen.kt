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
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.DropdownMenus.RegisterDropdownMenu
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions



@Preview
@Composable
fun RPUni1Screen(
    modifier: Modifier = Modifier,
    metodosViewModel: MetodosViewModel = MetodosViewModel(),
    continueClick: () -> Unit = {}
) {
    var carreras by remember { mutableStateOf(listOf<String>()) }

    var facultad by remember { mutableStateOf("SELECCIONAR FACULTAD") }

    var escuela by remember { mutableStateOf("SELECCIONAR CARRERA") }

    var ciclo by remember { mutableStateOf("") }

  //BgFondoCuestion()
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {

        Spacer(modifier = Modifier.height(15.dp))

        CustomTextCuestions(titulo = "Faculdad")

        Spacer(modifier = Modifier.height(20.dp))

        RegisterDropdownMenu(
            selectedItem = facultad,
            list = facultades_list.map { it.nombre },
            value = {facultadNombre ->
                facultad = facultadNombre
                val facu = facultades_list.find { it.nombre == facultadNombre }
                carreras = facu?.escuelas ?: listOf()
                escuela = "SELECCIONAR ESCUELA"
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextCuestions(titulo = "Escuela")

        Spacer(modifier = Modifier.height(20.dp))

        RegisterDropdownMenu(
            selectedItem = escuela,
            list = carreras,
            value = { escuela = it },
            enabled = carreras.isNotEmpty(),
            textToastError = "SELECCIONA UNA FACULTAD"
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextCuestions(titulo = "Ciclo")

        Spacer(modifier = Modifier.height(20.dp))

        RegisterDropdownMenu(
            ciclos_list,
            value = { ciclo = it }
        )

        Spacer(modifier = Modifier.height(20.dp))
        Btn_SiguienteGreen(
            title = "Continuar",
            onClick = {
                continueClick()
                metodosViewModel.completeRPUni1Screen(facultad,escuela, ciclo)

            },enabled = true)

        Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))

    }
}



private val ciclos_list = listOf(
    "SELECCIONAR",
    "I",
    "II",
    "III",
    "IV",
    "V",
    "VI",
    "VII",
    "VIII",
    "IX",
    "X"
)

private data class Facultad(
    val nombre:String,
    val escuelas: List<String>
)
private val facultades_list = listOf(
    Facultad(
        "FACULTAD DE BROMATOLOGÍA Y NUTRICIÓN",
        listOf("Bromatología y Nutrición")
    ),
    Facultad(
        "FACULTAD DE CIENCIAS",
        listOf(
            "Estadística e Informática",
            "Física",
            "Biología con mención a la Biotecnología",
            "Matemática Aplicada"
        )
    ),
    Facultad(
        "FACULTAD DE CIENCIAS ECONÓMICAS,CONTABLES Y FINANCIERAS",
        listOf(
            "Ciencias Contables y Financieras",
            "Economía y Finanzas"
        )
    ),
    Facultad(
        "FACULTAD DE CIENCIAS EMPRESARIALES",
        listOf(
            "Administración",
            "Gestión en Hotelería y Turismo",
            "Negocios Internacionales"
        )
    ),
    Facultad(
        "FACULTAD DE CIENCIAS SOCIALES",
        listOf(
            "Ciencias de la Comunicación",
            "Sociología",
            "Trabajo Social"
        )
    ),
    Facultad(
        "FACULTAD DE DERECHO Y CIENCIAS POLÍTICAS",
        listOf("Derecho")
    ),
    Facultad(
        "FACULTAD DE EDUCACIÓN",
        listOf(
            "Inicial",
            "Primaria",
            "Secundaria",
            "Física",
            "Tecnológica",
            "Construcciones Metálicas",
            "Electrónica"
        )
    ),
    Facultad(
        "FACULTAD DE INGENIERÍA AGRARIA, INDUSTRIAS ALIMENTARIAS Y AMBIENTAL",
        listOf(
            "Agronómica",
            "Ambiental",
            "Industrias Alimentarias",
            "Zootécnica"
        )
    ),
    Facultad(
        "FACULTAD DE INGENIERÍA CIVIL",
        listOf("Civil")
    ),
    Facultad(
        "FACULTAD DE INGENIERÍA INDUSTRIAL, SISTEMAS E INFORMÁTICA",
        listOf(
            "Ingeniería Industrial",
            "Ingeniería de Sistemas",
            "Ingeniería Informática",
            "Ingeniería Electrónica"
        )
    ),
    Facultad(
        "FACULTAD DE INGENIERÍA PESQUERA",
        listOf(
            "Pesquera",
            "Acuícola"
        )
    ),
    Facultad(
        "FACULTAD DE INGENIERÍA QUÍMICA Y METALÚRGICA",
        listOf(
            "Química",
            "Metalúrgica"
        )
    ),
    Facultad(
        "FACULTAD DE MEDICINA HUMANA",
        listOf(
            "Enfermería",
            "Medicina Humana"
        )
    )
)
