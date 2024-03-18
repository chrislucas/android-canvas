package com.br.experience.features.codelabs.arch.basicroomwithllivedata.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.db.dao.WordDao
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * https://github.com/android/codelab-android-room-with-a-view/blob/kotlin/app/src/main/java/com/example/android/roomwordssample/WordRoomDatabase.kt
 */

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class WordLiveDataDB : RoomDatabase() {

    abstract fun getWordDao(): WordDao

    companion object {
        @Volatile
        private var instance: WordLiveDataDB? = null


        private class WordDBCallback(private val coroutineScope: CoroutineScope): Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                instance?.getWordDao()?.let {
                    coroutineScope.launch(Dispatchers.IO) {
                        it.deleteAll()
                        it.insert(WordEntity(word = "Olá"))
                        it.insert(WordEntity(word = "Mundo"))
                    }
                }
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                Log.i("WORD_DB", "OPEN")
            }

            override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                super.onDestructiveMigration(db)
                Log.i("WORD_DB", "DestructiveMigration")
            }
        }

        fun getInstance(context: Context, coroutineScope: CoroutineScope): WordLiveDataDB? {
            return if (instance == null) {
                synchronized(WordLiveDataDB::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordLiveDataDB::class.java,
                        WordDao.TableFlowWord.TABLE_NAME
                    ).addCallback(WordDBCallback(coroutineScope))
                        .build()
                }
                instance
            } else {
                instance
            }
        }
    }
}