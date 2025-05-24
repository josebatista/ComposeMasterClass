package io.github.josebatista.composemasterclass.animations

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun InfiniteAnimations(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition()
    val ratio by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3_000),
            repeatMode = RepeatMode.Reverse
        )
    )
    val color by transition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            animation = tween(3_000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .graphicsLayer {
                    rotationZ = 360f * ratio
                    scaleX = ratio
                    scaleY = ratio
                }
                .size(100.dp)
//                .background(Color.Red)
                .drawBehind {
                    drawRect(color = color)
                }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun InfiniteAnimationsPreview() {
    ComposeMasterClassTheme {
        InfiniteAnimations()
    }
}
