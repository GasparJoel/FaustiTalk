package com.faustino.faustitalk.View.Components.DropdownMenus

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterDropdownMenu(
    list: List<String>,  value: (String) -> Unit
) {

    var selectText by remember {
        mutableStateOf(list[0])
    }

    var isExpanded by remember{
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(53.dp),
        colors = CardColors(
            containerColor = Color.White.copy(alpha = 0.04f),
            contentColor = Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = Color.White.copy(alpha = 0.04f),
        ),
        shape = RoundedCornerShape(15.dp),


    ) {
        Row(

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                //.padding(15.dp)
                .height(52.dp)
                .clickable {
                    isExpanded = true
                }

        ) {
            Text(
                text = selectText,
                modifier = Modifier.padding(start = 15.dp)
                //textAlign = TextAlign.Center,
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "",
                modifier = Modifier.padding(end = 15.dp),
                tint = Color.White.copy(alpha = 0.5f)
            )

        }
        DropdownMenu(
            expanded = isExpanded,
            modifier = Modifier.weight(1f),
            onDismissRequest = { isExpanded=false }


        ) {
            list.forEachIndexed{index,text ->
                if (text != "SELECCIONAR"){
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            selectText =list[index]
                            value( selectText)
                            isExpanded=false
                        },
                        // modifier = Modifier.fillMaxWidth(),
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding

                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterDropdownMenu(
    selectedItem: String,
    list: List<String>,
    value: (String) -> Unit,
    enabled: Boolean = true,
    textToastError : String = "Inabilitado"
) {
    val context = LocalContext.current

    var isExpanded by remember{
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(53.dp),
        colors = CardColors(
            containerColor = Color.White.copy(alpha = 0.04f),
            contentColor = Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = Color.White.copy(alpha = 0.04f),
        ),
        shape = RoundedCornerShape(15.dp),

    ) {
        Row(

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                //.padding(15.dp)
                .height(52.dp)
                .clickable {
                    if (enabled){
                        isExpanded = true
                    }else{
                        Toast.makeText(context, textToastError,Toast.LENGTH_SHORT).show()
                    }
                }

        ) {
            Text(
                text = selectedItem,
                modifier = Modifier.padding(start = 15.dp)
                //textAlign = TextAlign.Center,
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "",
                modifier = Modifier.padding(end = 15.dp),
                tint = Color.White.copy(alpha = 0.5f)
            )

        }
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded=false }


        ) {
            list.forEachIndexed{index,text ->

                DropdownMenuItem(
                    text = { Text(text = text) },
                    onClick = {
                        value( text)
                        isExpanded=false
                    },
                    // modifier = Modifier.fillMaxWidth(),
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding

                )

            }
        }
    }
}