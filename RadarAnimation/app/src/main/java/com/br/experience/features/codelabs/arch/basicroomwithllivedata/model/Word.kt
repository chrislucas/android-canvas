package com.br.experience.features.codelabs.arch.basicroomwithllivedata.model

import com.br.experience.features.codelabs.arch.basicroomwithllivedata.entity.WordEntity

data class Word(val value: String)

fun Word.toEntityWord() = WordEntity(word = value)

fun WordEntity.toWord() = Word(value = word)