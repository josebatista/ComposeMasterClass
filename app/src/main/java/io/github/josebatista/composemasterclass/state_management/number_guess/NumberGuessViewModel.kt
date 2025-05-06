package io.github.josebatista.composemasterclass.state_management.number_guess

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class NumberGuessViewModel : ViewModel() {
    private var numberToGuess = Random.nextInt(1, 101)
    private var numberOfTries = 0
    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    fun onAction(action: NumberGuessAction) {
        when (action) {
            NumberGuessAction.OnGuessClick -> {
                val guess = _state.value.numberText.toIntOrNull()
                guess?.let { numberOfTries++ }
                _state.update {
                    it.copy(
                        guessText = when {
                            guess == null -> "Please enter a number."
                            guess > numberToGuess -> "Nope, my number is larger."
                            guess < numberToGuess -> "Nope, mu number is smaller."
                            else -> "That was it! You needed $numberOfTries attempts."
                        },
                        isGuessCorrect = guess == numberToGuess,
                        numberText = ""
                    )
                }
            }

            is NumberGuessAction.OnNumberTextChange -> {
                _state.update { it.copy(numberText = action.numberText) }
            }

            NumberGuessAction.OnStartNewGameClick -> {
                numberToGuess = Random.nextInt(1, 101)
                numberOfTries = 0
                _state.update {
                    it.copy(
                        guessText = null,
                        isGuessCorrect = false,
                        numberText = ""
                    )
                }
            }
        }
    }
}
