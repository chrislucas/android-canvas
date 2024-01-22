package com.br.experience.features.codelabs.arch.basicroomcleanarch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.R

/**
 * Redesenhar o exemplo do link abaixo usando clean arch como arquitetura
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=pt-br#4
 */

class SampleWithCleanArchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_with_clean_arch)
    }
}