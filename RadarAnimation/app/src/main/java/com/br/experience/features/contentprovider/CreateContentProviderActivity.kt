package com.br.experience.features.contentprovider

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.br.experience.radaranimation.R


/**
 *
 * TODO
 *
 * Content providers
 * https://developer.android.com/guide/topics/providers/content-providers
 *
 *
 * Content provider basics
 * https://developer.android.com/guide/topics/providers/content-provider-basics
 *
 * Create a content provider
 * https://developer.android.com/guide/topics/providers/content-provider-creating
 *
 *
 * Content Providers in Android with Example
 * https://www.geeksforgeeks.org/content-providers-in-android-with-example/
 */

class CreateContentProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_content_provider)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}