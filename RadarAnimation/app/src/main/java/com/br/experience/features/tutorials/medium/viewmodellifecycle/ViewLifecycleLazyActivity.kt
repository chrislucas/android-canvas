package com.br.experience.features.tutorials.medium.viewmodellifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.R

/**
 * https://bladecoder.medium.com/viewlifecyclelazy-and-other-ways-to-avoid-view-memory-leaks-in-android-fragments-4aa982e6e579
 */
class ViewLifecycleLazyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_lifecycle_lazy)
    }
}