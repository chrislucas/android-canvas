package com.br.gridsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Problema:
 * Fica dificil de achar um video especifico de um perfil no instagram que produz muito conteudo, o videos não tem titulo no grid e nao
 * tem uma forma de pesquisar
 *
 * Solucao
 * E se tivesse um grid list com uma funcao de pesquisar por palavras que aparecem no título
 *
 * - Criar uma solucao que permita criar uma lista em grid cujo conteudo da lista seja um conteúdo (de preferencia generico)
 * e que esse conteudo possua uma descricao que pudesse ser pesquisada
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}