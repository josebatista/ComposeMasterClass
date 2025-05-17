package io.github.josebatista.composemasterclass.measurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.measurements.utility.printConstraints
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun SizeModifiersDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(100.dp)
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .printConstraints("Before 1. fillMaxWidth")
                .requiredWidth(300.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .printConstraints("After 1. fillMaxWidth")
                .background(Color.Yellow)
        ) {
            Text("Hello world!")
        }
    }
}

@Preview
@Composable
private fun SizeModifiersDemoPreview() {
    ComposeMasterClassTheme {
        SizeModifiersDemo()
    }
}
