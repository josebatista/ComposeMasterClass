package io.github.josebatista.composemasterclass.animations

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.basic_modifier.TriangleShape
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme
import kotlin.math.sqrt

@Composable
fun HomeWork1TriangleAnimation(
    modifier: Modifier = Modifier,
    width: Dp,
    colors: List<Color>
) {
    val transition = rememberInfiniteTransition()
    val ratio by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 5_000,
                easing = EaseInOut
            ),
        )
    )
    colors.forEachIndexed { index, color ->
        Box(
            modifier = modifier
                .graphicsLayer {
                    transformOrigin = TransformOrigin(
                        pivotFractionX = 0.5f,
                        pivotFractionY = 2f / 3f
                    )
                    val progressOffset = index * 360f
                    rotationZ = ratio * (360f + progressOffset)
                }
                .clip(TriangleShape)
                .width(width)
                .height(width * (sqrt(3f) / 2f))
                .background(color)

        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun HomeWork1TriangleAnimationPreview() {
    ComposeMasterClassTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            HomeWork1TriangleAnimation(
                width = 100.dp,
                colors = listOf(
                    Color.Red,
                    Color.Green,
                    Color.Blue,
                    Color.Yellow,
                    Color.Cyan,
                )
            )
        }
    }
}
