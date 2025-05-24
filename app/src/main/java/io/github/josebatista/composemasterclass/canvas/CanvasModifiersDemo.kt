package io.github.josebatista.composemasterclass.canvas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun CanvasModifiersDemo(modifier: Modifier = Modifier) {
//    Canvas(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        drawCircle(color = Color.Red)
//    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green)
//            .drawBehind {
////                drawCircle(color = Color.Red)
////                drawLine(
////                    brush = Brush.linearGradient(
////                        colors = listOf(Color.Red, Color.Blue),
////                    ),
////                    start = Offset.Zero,
////                    end = center,
////                    strokeWidth = 10.dp.toPx()
////                )
//                withTransform(
//                    transformBlock = {
//                        rotate(degrees = 90f)
//                    },
//                    drawBlock = {
//                        drawLine(
//                            brush = Brush.linearGradient(
//                                colors = listOf(Color.Red, Color.Blue),
//                            ),
//                            start = Offset.Zero,
//                            end = center,
//                            strokeWidth = 10.dp.toPx()
//                        )
//                    }
//                )
//            },
//            .drawWithContent {
//                drawCircle(color = Color.Red)
//                drawContent()
//                drawCircle(color = Color.Yellow, radius = 10.dp.toPx())
//            },
            .drawWithCache {
                onDrawWithContent {
                    drawCircle(color = Color.Red)
                    drawContent()
                    drawCircle(color = Color.Yellow, radius = 10.dp.toPx())
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text("Hello World!")
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun CanvasModifiersDemoPreview() {
    ComposeMasterClassTheme {
        CanvasModifiersDemo()
    }
}
