package com.br.experience.features.codelabs.arch.basicroomwithflow.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.br.experience.features.codelabs.arch.basicroomwithflow.db.dao.WordFlowDao
import com.br.experience.features.codelabs.arch.basicroomwithflow.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class WordFlowDB : RoomDatabase() {

    abstract fun getWordDao(): WordFlowDao

    companion object {

        @Volatile
        private var instance: WordFlowDB? = null

        private class WordFlowDBCallback(private val coroutineScope: CoroutineScope) : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                instance?.getWordDao()?.let {
                    coroutineScope.launch {
                        mockInsert(it)
                    }
                }
            }

            private suspend fun mockInsert(wordFlowDao: WordFlowDao) {
                with(wordFlowDao) {
                    deleteAll()
                    insert(WordEntity(word = "Olá"))
                    insert(WordEntity(word = "Mundo"))
                }
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                Log.i("WORD_FLOW_DB", "OPEN")
            }

            override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                super.onDestructiveMigration(db)
                Log.i("WORD_FLOW_DB", "DestructiveMigration")
            }
        }

        @JvmStatic
        fun getInstance(context: Context, coroutineScope: CoroutineScope): WordFlowDB? {
            return if (instance == null) {
                synchronized(WordFlowDB::class.java) {
                    instance = Room.databaseBuilder(
                        context,
                        WordFlowDB::class.java,
                        WordFlowDao.TableFlowWord.TABLE_NAME
                    ).addCallback(WordFlowDBCallback(coroutineScope)).build()
                }
                instance
            } else {
                instance
            }
        }
    }
}