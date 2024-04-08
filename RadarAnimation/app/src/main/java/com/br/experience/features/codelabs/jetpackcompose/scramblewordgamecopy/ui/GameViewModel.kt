package com.br.experience.features.codelabs.jetpackcompose.scramblewordgamecopy.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.br.experience.features.codelabs.jetpackcompose.scramblewordgamecopy.data.MAX_NO_OF_WORDS
import com.br.experience.features.codelabs.jetpackcompose.scramblewordgamecopy.data.SCORE_INCREASE
import com.br.experience.features.codelabs.jetpackcompose.scramblewordgamecopy.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val mUiState = MutableStateFlow(GameUIState())

    val uiState: StateFlow<GameUIState> = mUiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    private var userWords = mutableSetOf<String>()
    private var currentWord: String = ""

    init {
        resetGame()
    }

    internal fun resetGame() {
        userWords.clear()
        mUiState.value = GameUIState(recursivePickRandomWord())
    }

    internal fun updateUserGuess(guessedWord: String = "") {
        userGuess = guessedWord
    }

    internal fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            updateGameState(mUiState.value.score.plus(SCORE_INCREASE))
        } else {
            mUiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        updateUserGuess()
    }

    internal fun skipNextWord() {
        updateGameState(mUiState.value.score)
        updateUserGuess()
    }

    private fun updateGameState(newScore: Int) {
        mUiState.update { currentState ->
            if (userWords.size == MAX_NO_OF_WORDS) {
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = newScore,
                    isGameOver = true
                )
            } else {
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = recursivePickRandomWord(),
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = newScore
                )
            }
        }
    }

    private fun pickRandomWord(): String {
        currentWord = allWords.random()
        var times = 0
        while (userWords.contains(currentWord) || times < userWords.size) {
            currentWord = userWords.random()
            times += 1
        }
        userWords.add(currentWord)
        shuffleWord(currentWord)
        return currentWord
    }

    private fun recursivePickRandomWord(): String {
        currentWord = allWords.random()
        return if (userWords.contains(currentWord)) {
            recursivePickRandomWord()
        } else {
            userWords.add(currentWord)
            shuffleWord(currentWord)
        }
    }

    private fun shuffleWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }
}