package com.br.experience.features.codelabs.arch.basicroomwithflow.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.experience.features.codelabs.arch.basicroomwithflow.entity.WordEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("SELECT * FROM words ORDER BY word ASC")
    fun get(): Flow<List<WordEntity>>

    /**
     * A estratégia OnConflictStrategy.IGNORE ignora ua nova palavra
     * se ela for igua a que ja esta na lista.
     *
     * Sobre estrategias de conflito
     * https://developer.android.com/reference/androidx/room/OnConflictStrategy
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(wordEntity: WordEntity)

    @Query("DELETE FROM words")
    fun deleteAll()
}