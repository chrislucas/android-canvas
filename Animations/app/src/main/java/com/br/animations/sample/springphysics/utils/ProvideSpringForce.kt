package com.br.animations.sample.springphysics.utils

import androidx.dynamicanimation.animation.SpringForce


sealed class SpringForceDampingRatio(val value: Float) {
    object DampingRationLowBouncy : SpringForceDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
    object DampingRationHighBouncy : SpringForceDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
    object DampingRationMediumBouncy :
        SpringForceDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY)

    object DampingRationNoBouncy : SpringForceDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY)
}

sealed class SpringForceStiffness(val value: Float) {

    object StiffnessLow : SpringForceStiffness(SpringForce.STIFFNESS_LOW)
    object StiffnessHigh : SpringForceStiffness(SpringForce.STIFFNESS_HIGH)
    object StiffnessMedium : SpringForceStiffness(SpringForce.STIFFNESS_MEDIUM)
    object StiffnessVeryLow : SpringForceStiffness(SpringForce.STIFFNESS_VERY_LOW)

}

class SpringForceDependencies(
    val finalPosition: Float,
    val dampingRatio: SpringForceDampingRatio,
    val stiffness: SpringForceStiffness
)

/**
 * https://developer.android.com/reference/androidx/dynamicanimation/animation/SpringAnimation
 *
 * SpringAnimation eh uma animacao coordenada por uma instancia de SpringForce, essa por sua vez
 * define a "rigidez" (stiffness) da animacao e a taxa de "balanco/amortecimento/"
 * (do efeito de mola)
 *
 *  - Uma vez que a animacao foi iniciada a cada frame o spring force ira atualizar o valor e a velocidade
 *  da animacao
 *
 *  - A animacao continua ate que a spring force atinja o equilibrio, caso a configuracao  seja para
 *  que nunca o equilibrio seja atingido a oscilacao continuara ate que o programa seja encerrado
 *
 * Efeito under-damping
 * A mola esta definida com baixa rigidez
 * */

fun provideSpringForceDefault(finalPosition: Float) = SpringForce(finalPosition)
    .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
    .setStiffness(SpringForce.STIFFNESS_LOW)


fun provideSpringForce(dependencies: SpringForceDependencies) =
    dependencies.run {
        SpringForce(finalPosition)
            .setDampingRatio(dampingRatio.value)
            .setStiffness(stiffness.value)
    }

