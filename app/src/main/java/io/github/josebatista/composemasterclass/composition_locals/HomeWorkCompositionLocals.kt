package io.github.josebatista.composemasterclass.composition_locals

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme
import kotlinx.coroutines.launch

val LocalSnackbarState = staticCompositionLocalOf {
    SnackbarHostState()
}

@Composable
fun HomeWorkCompositionLocals(modifier: Modifier = Modifier) {
    val state = LocalSnackbarState.current
    val scope = rememberCoroutineScope()
    Button(
        modifier = modifier
            .wrapContentSize(),
        onClick = {
            scope.launch {
                state.showSnackbar("Hello world!")
            }
        }
    ) {
        Text("Click me!")
    }
}

@Preview
@Composable
private fun HomeWorkCompositionLocalsPreview() {
    ComposeMasterClassTheme {
        HomeWorkCompositionLocals()
    }
}
