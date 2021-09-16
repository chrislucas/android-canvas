package com.br.andcodelabs.feature.jetpack.navcomponent.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.andcodelabs.R

/**
 * https://developer.android.com/codelabs/android-navigation?hl=en&continue=https%3A%2F%2Fcodelabs.developers.google.com%2F%3Fcat%3Dandroid#0
 * */
class JetpackNavComponentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack_nav_component)
    }
}