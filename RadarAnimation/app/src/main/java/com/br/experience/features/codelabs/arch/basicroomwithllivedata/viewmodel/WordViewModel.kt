package com.br.experience.features.codelabs.arch.basicroomwithllivedata.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.entity.WordEntity
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.model.Word
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.model.toEntityWord
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.model.toWord
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.repository.WordLiveDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Interessante estudar as classs AndroidViewModel e ViewModel
 *
 * links interessantes
 * https://stackoverflow.com/questions/44148966/androidviewmodel-vs-viewmodel
 *
 * Vou usar AndroidViewModel nesse tutorial para explorar
 *
 * Ponto importante, esse acoplamento com a classe Application complica
 * ao tentar testar essa ViewModel de forma Unitaria por conta de uma dependencia
 * com uma classe do Android
 */

class WordViewModel(private val repository: WordLiveDataRepository) : ViewModel() {

    private val wordsMutableLiveData = MutableLiveData<List<Word>>()

    init {
        wordsMutableLiveData.value = repository.liveDataWordsEntity?.value?.map { it.toWord() } ?: listOf()
    }

    val wordsLiveData: LiveData<List<Word>> = wordsMutableLiveData

    fun insert(word: Word) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(word.toEntityWord())
            val list = repository.liveDataWordsEntity?.value?.map(WordEntity::toWord) ?: listOf<Word>()
            Log.i("ADDING_WORD", "$list")
            //wordsMutableLiveData.value = list
        }
    }

    class WordViewModelFactory(private val repository: WordLiveDataRepository): ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if(modelClass.isAssignableFrom(WordViewModel::class.java)) {
                WordViewModel(repository) as T
            } else {
                throw IllegalArgumentException("throws exception on create WordViewModel")
            }
        }
    }
}


