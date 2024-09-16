package com.faustino.faustitalk.View.Menu.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions
import com.faustino.faustitalk.ui.theme.Dark900

@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun Ajustes_Privacidad(modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier)  {

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .background(Dark900)
            .padding(horizontal = 32.dp),
    ) {

        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

        CustomTextCuestions(titulo = "Ajustes de Privacidad")

        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))



    }

}