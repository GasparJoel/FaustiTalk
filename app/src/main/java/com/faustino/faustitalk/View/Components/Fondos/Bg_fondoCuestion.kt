package com.faustino.faustitalk.View.Components.Fondos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun BgFondoCuestion(modifier: Modifier = Modifier) {
    Box (
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    0.0f to Color(0xFF171520),
                    100.0f to Color(0xFF171520),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )){
        Box (
            modifier = androidx.compose.ui.Modifier
                .graphicsLayer {
                    translationY = -800f
                }

                .size(500.dp)

                .blur(radius = 300.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .clip(CircleShape)
                .background(
                    Color(0xFF76F083).copy(alpha = 0.8f)
                    /*  brush = Brush.verticalGradient(listOf(
                        Color.Transparent,
                        GreenBase.copy(alpha = 0.6f)
                    ))*/


                )
                .align(Alignment.TopCenter)

        )

    }
}
