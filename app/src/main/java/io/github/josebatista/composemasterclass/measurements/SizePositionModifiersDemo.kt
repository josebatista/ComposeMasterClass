package io.github.josebatista.composemasterclass.measurements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun SizePositionModifiersDemo(modifier: Modifier = Modifier) {
    var screenSize by remember { mutableStateOf(IntSize.Zero) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(20.dp)
            .onSizeChanged { size ->
                screenSize = size
            }
            .onGloballyPositioned { coordinates ->
                println("Position: ${coordinates.positionInWindow()}")
            }
    ) {
        Text(
            text = if (screenSize.width > 1500) {
                "Wide screen!"
            } else {
                "Not so wide screen"
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun SizePositionModifiersDemoPreview() {
    ComposeMasterClassTheme {
        SizePositionModifiersDemo()
    }
}
