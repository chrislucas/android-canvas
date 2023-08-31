package com.br.experience.canvas.book.chp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.R
import com.br.experience.databinding.ActivityShowLineViewBinding

class ShowLineViewActivity : AppCompatActivity() {

    private val bindView: ActivityShowLineViewBinding by lazy {
        ActivityShowLineViewBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindView.root)
    }
}