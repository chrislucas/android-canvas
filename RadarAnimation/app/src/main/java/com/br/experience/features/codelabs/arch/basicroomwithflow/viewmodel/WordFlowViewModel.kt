package com.br.experience.features.codelabs.arch.basicroomwithflow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.br.experience.features.codelabs.arch.basicroomwithflow.model.Word
import com.br.experience.features.codelabs.arch.basicroomwithflow.model.toEntityWord
import com.br.experience.features.codelabs.arch.basicroomwithflow.repository.WordFlowRepository
import kotlinx.coroutines.launch

class WordFlowViewModel(private val repository: WordFlowRepository): ViewModel() {
    val words: LiveData<List<Word>> = repository.words.asLiveData()

    fun insert(word: Word) =
        viewModelScope.launch {
            repository.insert(word.toEntityWord())
        }

    class WordFlowViewModelFactory(private val repository: WordFlowRepository): ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            /**
             * @see Class.isAssignableFrom
             */
            return if(modelClass.isAssignableFrom(WordFlowViewModel::class.java)) {
                WordFlowViewModel(repository) as T
            } else {
                throw IllegalArgumentException("throws exception on create WordViewModel")
            }
        }
    }
}