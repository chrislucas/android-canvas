package com.br.experience.radaranimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.experience.databinding.ShowRadarViewAnimationBinding

class ShowRadarViewAnimationActivity : AppCompatActivity() {

    private val bindView: ShowRadarViewAnimationBinding by lazy { ShowRadarViewAnimationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindView.root)
    }
}