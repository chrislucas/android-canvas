package com.br.experience.canvas.drawing.plane

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.R
import com.br.experience.databinding.ActivityShowCartesianPlaneViewBinding

class ShowCartesianPlaneViewActivity : AppCompatActivity() {

    private val bindView: ActivityShowCartesianPlaneViewBinding by lazy {
        ActivityShowCartesianPlaneViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindView.root)
    }
}