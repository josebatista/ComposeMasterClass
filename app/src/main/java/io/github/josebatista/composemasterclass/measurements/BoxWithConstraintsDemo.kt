package io.github.josebatista.composemasterclass.measurements

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun BoxWithConstraintsDemo(modifier: Modifier = Modifier) {
    BoxWithConstraints(
        modifier = modifier
            .width(200.dp)
    ) {
        if (constraints.hasFixedWidth) {
            Text("Fixed width!")
        } else {
            Text("Dynamic width!")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun BoxWithConstraintsDemoPreview() {
    ComposeMasterClassTheme {
        BoxWithConstraintsDemo()
    }
}
