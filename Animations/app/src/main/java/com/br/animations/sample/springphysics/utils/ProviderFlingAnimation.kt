package com.br.animations.sample.springphysics.utils

import androidx.dynamicanimation.animation.FlingAnimation
import androidx.dynamicanimation.animation.FloatValueHolder

/**
 * https://developer.android.com/guide/topics/graphics/fling-animation
 * */


class FlingAnimationDependencies(
    val floatValue: FloatValueHolder,
    val startVelocity: Float,
    val friction: Float
)


fun providerFlingAnimation(dependencies: FlingAnimationDependencies) =
    dependencies.run {
        FlingAnimation(floatValue)
            .setStartVelocity(startVelocity)
            .setFriction(friction)
    }