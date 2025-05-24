package io.github.josebatista.composemasterclass.side_effects

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme
import kotlinx.coroutines.delay

@Composable
fun ProduceStateDemo(modifier: Modifier = Modifier) {
//    This combination can be implemented by a produceState
//    var counter by remember { mutableIntStateOf(0) }
//    LaunchedEffect(Unit) {
//        while (true) {
//            delay(1_000)
//            counter++
//        }
//    }

    /*
    It's not often used in a real app, as it's common to update the state in a viewmodel
     */
    val counter by produceState(0) {
        while (true) {
            delay(1_000)
            value += 1
        }
    }
    Text(
        text = counter.toString(),
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Preview(
    showBackground = true
)
@Composable
private fun ProduceStateDemoPreview() {
    ComposeMasterClassTheme {
        ProduceStateDemo()
    }
}
