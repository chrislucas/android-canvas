package com.br.experience.features.codelabs.arch.lifecycleawarecomponents.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.R

/**
 * Incorporate Lifecycle-Aware Components
 * https://developer.android.com/codelabs/android-lifecycles?hl=en#0
 */
class CodelabsLifecycleAwareComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codelabs_lifecycle_aware_components)
    }
}