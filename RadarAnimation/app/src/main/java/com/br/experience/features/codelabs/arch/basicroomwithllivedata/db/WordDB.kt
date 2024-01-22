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
abstract class WordDB : RoomDatabase() {

    abstract fun getWordDao(): WordDao

    companion object {
        @Volatile
        private var instance: WordDB? = null

        private const val TABLE_NAME = "word_database"

        private class WordDBCallback(private val coroutineScope: CoroutineScope): Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                instance?.let {
                    coroutineScope.launch(Dispatchers.IO) {
                        instance?.getWordDao()
                            ?.run {
                                deleteAll()
                                insert(WordEntity(word = "Olá"))
                                insert(WordEntity(word = "Mundo"))
                            }
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

        fun getInstance(context: Context, coroutineScope: CoroutineScope): WordDB? {
            return if (instance == null) {
                synchronized(WordDB::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordDB::class.java,
                        TABLE_NAME
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