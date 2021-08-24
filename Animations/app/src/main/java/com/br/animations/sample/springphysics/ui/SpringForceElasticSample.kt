package com.br.animations.sample.springphysics.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.fragment.app.Fragment
import com.br.animations.R
import com.br.animations.sample.springphysics.models.Point2f
import com.br.animations.sample.springphysics.utils.*


class SpringEffectSample private constructor() : Fragment() {

    private lateinit var imageView: ImageView

    private var currentPosition = Point2f(0.0f, 0.0f)
    private var previousPosition = Point2f(0.0f, 0.0f)

    private val setupAnimationImageViewX: SpringAnimation by lazy {
        springAnimationDefault(imageView, DynamicAnimation.X)
    }

    private val setupAnimationImageViewY: SpringAnimation by lazy {
        springAnimationDefault(imageView, DynamicAnimation.Y)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_spring_effect_sample, container,
            false
        )
        imageView = view.findViewById(R.id.iv_sample)
        setImageViewTouchListener()
        return view
    }

    /**
     * Setup baseado no sample com objetivo de estudar
     * https://developer.android.com/reference/androidx/dynamicanimation/animation/SpringAnimation
     * */


    private fun springAnimationDefault(
        view: View,
        property: FloatPropertyCompat<View>
    ): SpringAnimation {

        val springForceDependencies = SpringForceDependencies(
            0.0f,
            SpringForceDampingRatio.DampingRationLowBouncy,
            SpringForceStiffness.StiffnessLow
        )

        val springForce = provideSpringForce(springForceDependencies)

        val dependencies = GenSpringAnimationDependencies(
            view,
            springForce,
            property,
            0.0f,
            0.0f,
            1.0f
        )

        return provideSpringAnimation(dependencies)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setImageViewTouchListener() {
        imageView.setOnTouchListener { _, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    setupAnimationImageViewX.cancel()
                    setupAnimationImageViewY.cancel()

                    previousPosition = Point2f(imageView.x, imageView.y)
                    currentPosition = Point2f(
                        imageView.x - event.rawX, imageView.y - event.rawY
                    )

                    Log.i(
                        "ACTION_DOWN", "P(%.2f, %.2f), C(%.2f, %.2f)"
                            .format(
                                previousPosition.x,
                                previousPosition.y,
                                currentPosition.x,
                                currentPosition.y
                            )
                    )

                }
                MotionEvent.ACTION_MOVE -> {
                    imageView.x = event.rawX + currentPosition.x
                    imageView.y = event.rawY + currentPosition.y

                    Log.i(
                        "ACTION_MOVE", "Image p(%.2f, %.2f)".format(imageView.x, imageView.y)
                    )
                }
                MotionEvent.ACTION_UP -> {
                    setupAnimationImageViewX.animateToFinalPosition(previousPosition.x)
                    setupAnimationImageViewY.animateToFinalPosition(previousPosition.y)

                    Log.i(
                        "ACTION_MOVE",
                        "Prev(%.2f, %.2f)".format(previousPosition.x, previousPosition.y)
                    )
                }
            }
            true
        }

    }


    companion object {

        val TAG: String = SpringEffectSample::class.java.simpleName

        @JvmStatic
        fun newInstance() =
            SpringEffectSample()
    }
}