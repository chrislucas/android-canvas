package com.br.labanimation.springphysics.features.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.labanimation.R
import com.br.labanimation.databinding.ActivityInitAnimationBinding

/**
 * https://developer.android.com/guide/topics/graphics/spring-animation
 *
 *
 */

class InitAnimationActivity : AppCompatActivity() {

    val bindView: ActivityInitAnimationBinding by lazy {
        ActivityInitAnimationBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init_animation)


        //ObjectAnimator.ofFloat(bindView.)

    }
}