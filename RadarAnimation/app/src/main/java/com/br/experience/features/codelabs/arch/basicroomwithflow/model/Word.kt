package com.br.experience.features.codelabs.arch.basicroomwithflow.model

import com.br.experience.features.codelabs.arch.basicroomwithflow.entity.WordEntity

data class Word(val content: String)

fun Word.toEntityWord() = WordEntity(word = content)

fun WordEntity.toWord() = Word(content = word)