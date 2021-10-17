package com.br.animations.sample.springphysics.utils

import android.view.View
import androidx.dynamicanimation.animation.*


fun provideDefaultSpringAnimation(view: View, startVelocity: Float) =
    provideDefaultSpringAnimation(view, startVelocity, 0.0f)


fun provideDefaultSpringAnimation(view: View, startVelocity: Float, finalPosition: Float) =
    SpringAnimation(view, DynamicAnimation.X, 0.0f)
        .setStartVelocity(startVelocity)


class ViewSpringAnimationDependencies(
    val view: View,
    val springForce: SpringForce,
    val viewPropertyAnimation: DynamicAnimation.ViewProperty,
    val finalPosition: Float,
    val minValue: Float,
    val startValue: Float
)

class GenSpringAnimationDependencies<K>(
    val targetAnimation: K,
    val springForce: SpringForce,
    val propertyAnimation : FloatPropertyCompat<K>,
    val finalPosition: Float,
    val minValue: Float,
    val startValue: Float
)

/**
 * https://developer.android.com/reference/androidx/dynamicanimation/animation/SpringAnimation
 * */

fun provideSpringAnimation(
    dependencies: ViewSpringAnimationDependencies
) =
    dependencies.run {
        SpringAnimation(view, viewPropertyAnimation, finalPosition)
            .setMinValue(minValue)
            .setSpring(springForce)
            .setStartValue(startValue)
    }

/**
 * uma funcao generica para tratar de qualquer elemento que for receber animacao e possa
 * ser parametrizado no objeto
 * {@link FloatPropertyCompat}
 * */
fun <K> provideSpringAnimation(dependencies: GenSpringAnimationDependencies<K>) =
    dependencies.run {
        SpringAnimation(targetAnimation, propertyAnimation, finalPosition)
            .setMinValue(minValue)
            .setSpring(springForce)
            .setStartValue(startValue)
    }


fun providerSpringAnimation(floatValue: FloatValueHolder) = SpringAnimation(floatValue)