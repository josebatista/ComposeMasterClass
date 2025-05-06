package io.github.josebatista.composemasterclass.state_management.number_guess

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun NumberGuessRoot(modifier: Modifier = Modifier) {
    val viewModel = viewModel<NumberGuessViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    NumberGuessScreen(
        modifier = modifier,
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun NumberGuessScreen(
    modifier: Modifier = Modifier,
    state: NumberGuessState,
    onAction: (NumberGuessAction) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        TextField(
            value = state.numberText,
            onValueChange = { newText -> onAction(NumberGuessAction.OnNumberTextChange(newText)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onAction(NumberGuessAction.OnGuessClick) }
            )
        )
        Button(onClick = { onAction(NumberGuessAction.OnGuessClick) }) {
            Text("Make guess")
        }
        if (state.guessText != null) {
            Text(
                text = state.guessText,
            )
        }
        if (state.isGuessCorrect) {
            Button(onClick = { onAction(NumberGuessAction.OnStartNewGameClick) }) {
                Text("Start new game")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NumberGuessScreenPreview() {
    ComposeMasterClassTheme {
        NumberGuessScreen(
            state = NumberGuessState(),
            onAction = {}
        )
    }
}
