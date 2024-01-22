package com.br.experience.features.codelabs.arch.basicroomwithflow.repository

import com.br.experience.features.codelabs.arch.basicroomwithflow.dao.WordDao
import com.br.experience.features.codelabs.arch.basicroomwithflow.entity.WordEntity
import com.br.experience.features.codelabs.arch.basicroomwithflow.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * https://github.com/android/codelab-android-room-with-a-view/blob/kotlin/app/src/main/java/com/example/android/roomwordssample/WordRepository.kt
 */
class WordRepository(private val dao: WordDao) {

    val words: Flow<List<Word>> = dao.get().map { entities -> entities.map { Word(it.word) } }

    suspend fun insert(entity: WordEntity) {
        dao.insert(entity)
    }
}