package com.br.labanimation.springphysics.features.start.flinganim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.labanimation.R
import com.br.labanimation.databinding.ActivityFlingAnimationBinding

/**
 * https://developer.android.com/guide/topics/graphics/fling-animation
 *
 */

class FlingAnimationActivity : AppCompatActivity() {


    private val bindView: ActivityFlingAnimationBinding by lazy {
        ActivityFlingAnimationBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fling_animation)


    }
}