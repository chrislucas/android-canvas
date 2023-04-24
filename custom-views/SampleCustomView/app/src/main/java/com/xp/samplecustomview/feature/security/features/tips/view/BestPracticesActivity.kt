package com.xp.samplecustomview.feature.security.features.tips.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xp.samplecustomview.R

/**
 * App security best practices
 * https://developer.android.com/topic/security/best-practices
 *
 * Tips
 * https://developer.android.com/training/articles/security-tips
 */
class BestPracticesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_practices)
    }
}