package com.br.experience.features.funwithrobolectric

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.R

/**
 * https://robolectric.org/writing-a-test/
 */
class FirstTestWithRobolectricActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_test_with_robolectric)
    }
}