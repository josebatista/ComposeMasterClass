package io.github.josebatista.composemasterclass.state_management.number_guess

sealed interface NumberGuessAction {
    data object OnGuessClick : NumberGuessAction
    data class OnNumberTextChange(val numberText: String) : NumberGuessAction
    data object OnStartNewGameClick : NumberGuessAction
}
