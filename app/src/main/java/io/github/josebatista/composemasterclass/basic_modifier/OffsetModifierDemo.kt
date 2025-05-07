package io.github.josebatista.composemasterclass.basic_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun OffsetModifierDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
//            .offset(
//                x = 40.dp,
//                y = 20.dp
//            )
    ) {
        Text(
            text = "Hello World!",
            modifier = Modifier
//                .offset(
//                    x = 40.dp,
//                    y = 20.dp
//                )
                .offset {
                    IntOffset(x = 40.dp.roundToPx(), y = 20.dp.roundToPx())
                }
                .background(Color.Green)
        )
        Text(
            text = "Hello World!",
            modifier = Modifier.background(Color.Yellow)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OffsetModifierDemoPreview() {
    ComposeMasterClassTheme { OffsetModifierDemo() }
}
