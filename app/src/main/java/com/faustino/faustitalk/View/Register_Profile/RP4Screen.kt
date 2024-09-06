package com.faustino.faustitalk.View.Register_Profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions
import com.faustino.faustitalk.ui.theme.Dark900
import com.faustino.faustitalk.ui.theme.Green300
import com.faustino.faustitalk.View.Components.Items.ItemSelectInterest

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun RP4Screen(modifier: Modifier = Modifier, finishClick: () -> Unit = {}) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
    ) {
        Spacer(modifier = Modifier.height(26.dp))
        CustomTextCuestions(titulo = "Elige tus Intereses")
        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 0.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(items) { _, item ->
                GridItemSelect(item = item)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Btn_SiguienteGreen(title = "Continuar", onClick = finishClick, enabled = true)
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun GridItemSelect(item: ItemSelectInterest) {
    var hiddenIconSelect by remember { mutableStateOf(false) }

    val colorButton = if (hiddenIconSelect) Green300 else Color.White.copy(0.09f)
    val colorText = if (hiddenIconSelect) Dark900 else Color.White

    Button(
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorButton),
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        onClick = { hiddenIconSelect = !hiddenIconSelect }
    ) {
        Text(modifier = Modifier.padding(end = 4.dp), text = item.emoji, fontSize = 17.sp)
        Text(
            text = item.text,
            fontSize = 14.sp,
            color = colorText,
            textAlign = TextAlign.Center
        )
    }
}

private val items = listOf(
    ItemSelectInterest("⚽", "Fútbol"),
    ItemSelectInterest("🎨", "Arte"),
    ItemSelectInterest("🎮", "Video juegos"),
    ItemSelectInterest("🎵", "Música"),
    ItemSelectInterest("📚", "Lectura"),
    ItemSelectInterest("🏀", "Baloncesto"),
    ItemSelectInterest("🍳", "Cocina"),
    ItemSelectInterest("✈️", "Viajar"),
    ItemSelectInterest("🎬", "Cine"),
    ItemSelectInterest("🕹️", "Juegos retro"),
    ItemSelectInterest("🚴‍♂️", "Ciclismo"),
    ItemSelectInterest("💻", "Tecnología"),
    ItemSelectInterest("🎤", "Cantar"),
    ItemSelectInterest("🏋️‍♂️", "Gimnasio"),
    ItemSelectInterest("📸", "Fotografía"),
    ItemSelectInterest("🧘‍♂️", "Yoga"),
    ItemSelectInterest("🏊‍♂️", "Natación"),
    ItemSelectInterest("🎭", "Teatro"),
    ItemSelectInterest("🎹", "Piano"),
    ItemSelectInterest("🏕️", "Camping"),
    ItemSelectInterest("📈", "Inversiones"),
    ItemSelectInterest("🎣", "Pesca"),
    ItemSelectInterest("🏖️", "Playa"),
    ItemSelectInterest("🎯", "Dardos"),
    ItemSelectInterest("🌱", "Jardinería"),
    ItemSelectInterest("🐶", "Mascotas"),
    ItemSelectInterest("🍷", "Vino"),
    ItemSelectInterest("🚗", "Autos"),
    ItemSelectInterest("🛹", "Skateboarding"),
    ItemSelectInterest("🎾", "Tenis"),
    ItemSelectInterest("🎿", "Esquí"),
    ItemSelectInterest("📖", "Escritura"),
    ItemSelectInterest("🏇", "Equitación"),
    ItemSelectInterest("🏹", "Tiro con arco"),
    ItemSelectInterest("🎧", "Podcasts"),
    ItemSelectInterest("🎻", "Violín")
)
