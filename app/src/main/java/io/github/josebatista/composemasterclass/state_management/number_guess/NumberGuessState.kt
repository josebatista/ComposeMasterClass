package io.github.josebatista.composemasterclass.state_management.number_guess

data class NumberGuessState(
    val numberText: String = "",
    val guessText: String? = null,
    val isGuessCorrect: Boolean = false,
)
