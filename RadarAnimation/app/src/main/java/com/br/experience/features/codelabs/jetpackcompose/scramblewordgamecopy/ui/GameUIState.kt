package com.br.experience.features.codelabs.jetpackcompose.scramblewordgamecopy.ui

data class GameUIState(
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 1,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)