package com.br.experience.features.codelabs.arch.basicroomwithflow.repository

import android.content.Context
import com.br.experience.features.codelabs.arch.basicroomwithflow.db.WordFlowDB
import com.br.experience.features.codelabs.arch.basicroomwithflow.db.dao.WordFlowDao
import com.br.experience.features.codelabs.arch.basicroomwithflow.entity.WordFlowEntity
import com.br.experience.features.codelabs.arch.basicroomwithflow.model.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

/**
 * https://github.com/android/codelab-android-room-with-a-view/blob/kotlin/app/src/main/java/com/example/android/roomwordssample/WordRepository.kt
 */
class WordFlowRepository(ctx: Context, coroutineScope: CoroutineScope) {

    private val dao: WordFlowDao? = WordFlowDB.getInstance(ctx, coroutineScope)?.getWordDao()

    val words: Flow<List<Word>> = dao?.get()?.map { entities ->
            entities.map { Word(it.word) }
        } ?: flowOf(listOf())

    suspend fun insert(entity: WordFlowEntity) {
        dao?.insert(entity) ?: throw Exception("Dao undefined")
    }
}