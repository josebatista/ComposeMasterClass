package io.github.josebatista.composemasterclass.state_management

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var counter by remember {
        // remember "cache" the values
        // remember don't survives configuration changes (rotation), for this use rememberSavable
        mutableIntStateOf(0)
        // don't use mutableListOf, mutableMapOf, because compose will check the references
        // even if the values change the reference is the same, and compose will not recompose
    }
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                counter++
            }
        ) {
            // counter++ - cause infinity loop, never update state directly in composable function.
            // State should only be updated in normal lambdas/functions
            Text("Counter: $counter")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun CounterPreview() {
    ComposeMasterClassTheme {
        Counter()
    }
}
