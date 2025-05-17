package io.github.josebatista.composemasterclass.measurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun IntrinsicSizeDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Min)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Red)
        ) {
            Text("Hello World!")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun IntrinsicSizeDemoPreview() {
    ComposeMasterClassTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            IntrinsicSizeDemo()
        }
    }
}
