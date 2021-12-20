package com.br.labanimation.springphysics.features.start

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.br.labanimation.R
import com.br.labanimation.databinding.ActivityFirstMoveAnimationBinding


/**
 *
 * Move a View with Animation
 * https://developer.android.com/training/animation/reposition-view
 *
 * Tutorial
 * https://www.geeksforgeeks.org/objectanimator-in-android-with-example/
 */

class FirstMoveAnimationActivity : AppCompatActivity() {

    private val bindView: ActivityFirstMoveAnimationBinding by lazy {
        ActivityFirstMoveAnimationBinding.inflate(
            layoutInflater
        )
    }

    private val animatorListener = object : Animator.AnimatorListener {

        override fun onAnimationStart(animation: Animator?) {
            Log.i("1ST_SAMPLE_ANIMATION", "START")

        }

        override fun onAnimationEnd(animation: Animator?) {
            Log.i("1ST_SAMPLE_ANIMATION", "START")

        }

        override fun onAnimationCancel(animation: Animator?) {
            Log.i("1ST_SAMPLE_ANIMATION", "CANCEL")

        }

        override fun onAnimationRepeat(animation: Animator?) {
            Log.i("1ST_SAMPLE_ANIMATION", "REPEAT")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindView.root)

        val animator = ObjectAnimator.ofFloat(
            bindView.ivSampleImageToMove,
            "translationY",
            200f
        )

        animator.duration = 3000

        /**
         * ObjectAnimator
         * https://developer.android.com/reference/android/animation/ObjectAnimator
         * https://developer.android.com/guide/topics/graphics/prop-animation#object-animator
         * */

        bindView.ivSampleImageToMove.setOnClickListener {
            Toast.makeText(it.context, "Clicked", Toast.LENGTH_SHORT).show()
            if (!animator.isStarted)
                animator.start()
            animator.addListener(animatorListener)
        }


    }
}