package com.br.experience.canvas.book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.experience.databinding.ActivityFeatureEachChapterBinding

class FeatureEachChapterActivity : AppCompatActivity() {

    private val bindView: ActivityFeatureEachChapterBinding by lazy {
        ActivityFeatureEachChapterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindView.root)
    }
}