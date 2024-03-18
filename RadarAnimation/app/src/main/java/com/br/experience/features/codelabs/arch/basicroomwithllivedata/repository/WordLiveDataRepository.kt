package com.br.experience.features.codelabs.arch.basicroomwithllivedata.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.db.WordLiveDataDB
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.entity.WordEntity
import kotlinx.coroutines.CoroutineScope

class WordLiveDataRepository(ctx: Context, coroutineScope: CoroutineScope) {

    private val dao = WordLiveDataDB.getInstance(ctx, coroutineScope)?.getWordDao()
    val liveDataWordsEntity: LiveData<List<WordEntity>>? = dao?.get()

    suspend fun insert(entity: WordEntity) {
        dao?.insert(entity)
    }
}