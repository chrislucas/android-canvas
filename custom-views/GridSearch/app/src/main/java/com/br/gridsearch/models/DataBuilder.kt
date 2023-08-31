package com.br.gridsearch.models

object DataBuilder {

    fun mockedContent(): List<Data> = listOf(
        Data(
            Photo("", "foto do mar")
        ),

        Data(
            Video("", "video do mar")
        )
    )
}