package com.br.gridsearch.models

/*
    Representação de um conteudo no grid
    - questao a se resolver: Criar um gerenciador de construcao de conteudo. Dado um conteudo C, como
 */
data class Data(val content: Content) {
    val description: String  = content.description
}