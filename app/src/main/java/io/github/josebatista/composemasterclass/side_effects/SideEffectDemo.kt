package io.github.josebatista.composemasterclass.side_effects

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun SideEffectDemo(modifier: Modifier = Modifier) {
    var counter by remember { mutableIntStateOf(0) }
    Button(
        onClick = { counter++ }
    ) {
//        counter++ - This is a side effect because it is not a recomposable function
        Text("Counter: $counter")
    }
}

@Preview
@Composable
private fun SideEffectDemoPreview() {
    ComposeMasterClassTheme {
        SideEffectDemo()
    }
}
