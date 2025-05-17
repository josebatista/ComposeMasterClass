package io.github.josebatista.composemasterclass.measurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

inline fun Modifier.applyIf(condition: Boolean, block: Modifier.() -> Modifier): Modifier {
    return if (condition) then(block()) else this
}

@Composable
fun SimpleModifierDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(100.dp)
            .applyIf(true) {
                Modifier
                    .background(Color.Red)
                    .padding(16.dp)
                    .background(Color.Gray)
            }
    )
}

@Preview
@Composable
private fun SimpleModifierDemoPreview() {
    ComposeMasterClassTheme {
        SimpleModifierDemo()
    }
}
