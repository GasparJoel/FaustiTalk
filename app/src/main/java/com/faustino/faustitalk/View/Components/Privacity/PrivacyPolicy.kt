package com.faustino.faustitalk.View.Components.Privacity

import android.app.Activity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun PrivacyPolicy(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onAccept: () -> Unit,
    showButtonsAndCheckbox: Boolean // PARAMETRO PARA MOSTRAR O NO LOS BOTONES Y CHECKBOX
) {

    // Texto constante que siempre se mostrará
    // Términos y Condiciones y Políticas de Privacidad
    val constantText = "Este es un texto constante muy largo. ".repeat(120)

    // Estado para manejar si el CheckBox está marcado o no
    var isChecked by remember { mutableStateOf(false) }

    // Obtener la actividad actual para cerrarla
    val activity = (LocalContext.current as? Activity)

    // Obtener la altura total de la pantalla
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss() }, // Cierra el diálogo al hacer clic fuera
            confirmButton = {
                if (showButtonsAndCheckbox) {
                    Row(
                        modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Cerrar la aplicación luego de NO ACEPTAR nuestros Términos y Condiciones y Políticas de Privacidad
                        Button(onClick = { activity?.finish() }) {
                            Text("No Acepto")
                        }
                        // PERMITE ACEPTAR LOS TÉRMINOS Y CONDICIONES SIEMPRE Y CUANDO EL CHECKBOX ESTÁ MARCADO
                        Button(onClick = { onAccept() }, enabled = isChecked) {
                            Text("Aceptar")
                        }
                    }
                }
            },
            text = {
                Column(
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxWidth()
                        .heightIn(min = 100.dp, max = screenHeight * 0.85f) // Usa el 85% de la pantalla
                        .padding(0.dp)
                ) {
                    LazyColumn(
                        modifier = androidx.compose.ui.Modifier.weight(1f)
                    ) {
                        item {
                            // Texto con estilo personalizado
                            Text(
                                text = constantText,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                )
                            )
                        }
                    }

                    // MOSTRAR EL CHECKBOX SI ESTA PERMITIDO
                    if (showButtonsAndCheckbox) {
                        Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { isChecked = it }
                            )
                            Text(text = "Estoy de acuerdo con lo leído")
                        }
                    }
                }
            }
        )
    }

}