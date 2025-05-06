package io.github.josebatista.composemasterclass.state_management

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun StateHoistingDemo(modifier: Modifier = Modifier) {
    var counter by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CounterStateLess(
            counter = counter,
            onIncrement = {
                counter++
            }
        )
        Button(
            onClick = {
                counter = 0
            }
        ) {
            Text("Reset counter")
        }
    }
}

@Composable
private fun CounterStateLess(
    modifier: Modifier = Modifier,
    counter: Int = 0,
    onIncrement: () -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onIncrement
        ) {
            Text("Counter: $counter")
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
private fun StateHoistingDemoPreview() {
    ComposeMasterClassTheme {
        StateHoistingDemo()
    }
}
