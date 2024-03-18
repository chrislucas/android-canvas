package com.br.experience.features.codelabs.arch.basicroomwithflow.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.experience.features.codelabs.arch.basicroomwithflow.db.dao.WordFlowDao.TableFlowWord.TABLE_NAME
import com.br.experience.features.codelabs.arch.basicroomwithflow.entity.WordEntity

import kotlinx.coroutines.flow.Flow




/**
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin#5
 */
@Dao
interface WordFlowDao {

    object TableFlowWord {
        const val TABLE_NAME: String = "words_flow"
    }

    @Query("SELECT * FROM $TABLE_NAME ORDER BY word ASC")
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

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAll()
}