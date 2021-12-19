package com.br.labanimation.springphysics.features.start.flinganim

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.labanimation.R
import com.br.labanimation.databinding.ActivityFlingAnimationBinding

/**
 * https://developer.android.com/guide/topics/graphics/fling-animation
 *
 * Move a View with Animation
 * https://developer.android.com/training/animation/reposition-view
 */

class FlingAnimationActivity : AppCompatActivity() {


    val bindView: ActivityFlingAnimationBinding by lazy {
        ActivityFlingAnimationBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fling_animation)

        ObjectAnimator.ofFloat(
            bindView.ivDraggable,
            "translationX",
            100f
        ).apply {
            duration = 2000
            start()
        }
    }
}