package com.br.experience.features.codelabs.viewmodelunittest.scramblewordgamecopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.databinding.ActivityScrambleWordGameViewModelUnitTestCodelabsBinding

/**
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-test-viewmodel#0
 */
class ScrambleWordGameActivity : AppCompatActivity() {

    private val binding: ActivityScrambleWordGameViewModelUnitTestCodelabsBinding by lazy {
        ActivityScrambleWordGameViewModelUnitTestCodelabsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.startGameScrambleWordActivity.setOnClickListener {
            startActivity(Intent(this, ScrambleGameActivity::class.java))
        }
    }
}