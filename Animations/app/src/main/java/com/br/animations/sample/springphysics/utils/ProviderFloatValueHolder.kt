package com.br.animations.sample.springphysics.utils

import androidx.dynamicanimation.animation.FloatValueHolder

/**
 * https://developer.android.com/reference/androidx/dynamicanimation/animation/SpringAnimation
 * Classe que armazena um valor float como atributo. Essa classe possui um setter e getter para
 * modificar e acessar esse valor de ponto flutuante
 *
 *  - Animacoes sao executadas a partir de uma isntancia de FloatValueHolder
 *
 *  - A cada frame de execucao da animcao, o valor armazenado por essa classe eh atualizado
 *  atraves do setter
 *
 *  - a instancia da animacao pode recuperar esse valor atraves do getter
 * */


fun providerFloatValueHolder(value: Float) = FloatValueHolder(value)