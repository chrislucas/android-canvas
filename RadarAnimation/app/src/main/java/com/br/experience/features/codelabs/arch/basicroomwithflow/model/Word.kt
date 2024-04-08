package com.br.experience.features.codelabs.arch.basicroomwithflow.model

import com.br.experience.features.codelabs.arch.basicroomwithflow.entity.WordFlowEntity

data class Word(val content: String)

fun Word.toEntityWord() = WordFlowEntity(word = content)

fun WordFlowEntity.toWord() = Word(content = word)