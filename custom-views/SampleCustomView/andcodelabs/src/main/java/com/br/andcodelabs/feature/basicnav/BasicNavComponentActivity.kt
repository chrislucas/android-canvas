package com.br.andcodelabs.feature.basicnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.andcodelabs.R

/**
 * https://developer.android.com/guide/navigation/navigation-deep-link
 * https://github.com/android/architecture-components-samples/tree/main/NavigationBasicSample
 * */

class BasicNavComponentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_nav_component)
    }
}