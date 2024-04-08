package com.br.experience.features.codelabs.arch.basicroomwithllivedata.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = WordEntity.TABLE_NAME)
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "word")
    val word: String
) {
    companion object {
        const val TABLE_NAME = "words_livedata"
    }
}