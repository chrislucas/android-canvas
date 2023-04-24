package com.br.experience

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.R
import com.br.experience.radaranimation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}