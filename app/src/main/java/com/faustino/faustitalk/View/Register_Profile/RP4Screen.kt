package com.faustino.faustitalk.View.Register_Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faustino.faustitalk.R
import com.faustino.faustitalk.View.Components.Butons.Btn_SiguienteGreen
import com.faustino.faustitalk.View.Components.Fondos.BgFondoCuestion
import com.faustino.faustitalk.View.Components.Items.ItemSelectInterest
import com.faustino.faustitalk.View.Components.Texts.CustomTextCuestions
import com.faustino.faustitalk.View.Components.Texts.Text300
import com.faustino.faustitalk.ui.theme.Dark900
import com.faustino.faustitalk.ui.theme.Green300

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun RP4Screen(modifier: Modifier = Modifier) {

    BgFondoCuestion()
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
    ) {

        Spacer(modifier = Modifier.height(28.dp))
        CustomTextCuestions(titulo = "Elige tus Intereses")
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 16.dp),
            // columns = GridCells.Fixed(2)
        ) {
            itemsIndexed(items) { index, item ->
                Box(contentAlignment = Alignment.CenterStart){
                    GridItemSelect(item = item)

                }

            }
        }
        /*
        FlowRow(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
//contentPadding = PaddingValues(vertical = 16.dp),
// columns = GridCells.Fixed(2)
        ) {
            items.forEach { item ->
                //Box(contentAlignment = Alignment.CenterStart){
                GridItemSelect(item = item)
                //   }

            }
        }*/
        Spacer(modifier = Modifier.height(20.dp))
        Btn_SiguienteGreen(title = "Continuar" , onClick = { },enabled = true)
        Spacer(modifier = Modifier.height(50.dp))
    }



}
/*
FlowRow(
modifier = Modifier
.weight(1f)
.fillMaxWidth(),
//contentPadding = PaddingValues(vertical = 16.dp),
// columns = GridCells.Fixed(2)
) {
    items.forEach { item ->
        //Box(contentAlignment = Alignment.CenterStart){
        GridItemSelect(item = item)
        //   }

    }
}
*/

@Composable
fun GridItemSelect(item:ItemSelectInterest) {

    var hiddenIconSelect by remember { mutableStateOf(false) }

    var colorButton = if (hiddenIconSelect) {
        Green300
    }else{
        Color.White.copy(0.09f)
    }
    var colorText = if (hiddenIconSelect) {
        Dark900
    }else{
        Color.White
    }

        Button (
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorButton
            ),
            modifier = Modifier.padding(horizontal = 2.dp)

            ,
            onClick = {
                hiddenIconSelect = !hiddenIconSelect
            },

            )
        {/*
            //Box( contentAlignment = Alignment.CenterStart) {
                if(hiddenIconSelect){
                    Image(painter = painterResource(id = R.drawable.ic_checkselect), contentDescription = "" , modifier = Modifier.padding(start = 2.dp, end = 6.dp))
                }else{
                }*/
                    Text(modifier = Modifier.padding(end = 4.dp), text = item.emoji , fontSize = 20.sp, )

                Text(
                    modifier = Modifier
                        //.padding(start = 28.dp)
                        ,
                    text = item.text ,
                    fontSize = 20.sp,
                    color = colorText,
                    textAlign = TextAlign.Center

                )
            //}
        }


}

private val items = listOf(
    ItemSelectInterest("⚽","Fútbol"),
    ItemSelectInterest("🎨", "Arte"),
    ItemSelectInterest("🎮", "Videojuegos"),
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
    ItemSelectInterest("💻", "Tecnología"),
    ItemSelectInterest("📸", "Fotografía"),
    ItemSelectInterest("⚽", "Fútbol"),
    ItemSelectInterest("🎨", "Arte"),
    ItemSelectInterest("🎮", "Videojuegos"),
    ItemSelectInterest("🎵", "Música"),
    ItemSelectInterest("📚", "Lectura"),
    ItemSelectInterest("🏀", "Baloncesto"),
    ItemSelectInterest("🍳", "Cocina"),
    ItemSelectInterest("✈️", "Viajar"),
    ItemSelectInterest("🎬", "Cine"),
    ItemSelectInterest("🚴‍♂️", "Ciclismo"),
    ItemSelectInterest("🎤", "Cantar"),
    ItemSelectInterest("🧘‍♂️", "Yoga"),
    ItemSelectInterest("💻", "Tecnología"),
    ItemSelectInterest("📸", "Fotografía"),
    ItemSelectInterest("🏊‍♂️", "Natación"),
    ItemSelectInterest("🎭", "Teatro"),
    ItemSelectInterest("🎹", "Piano"),
    ItemSelectInterest("🏋️‍♂️", "Gimnasio"),
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
    ItemSelectInterest("🕹️", "Juegos retro"),
    ItemSelectInterest("🎧", "Podcasts"),
    ItemSelectInterest("🎻", "Violín")
)