package com.br.experience.features.tutorials.medium.androidstorage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.br.experience.radaranimation.R

/**
 * Parte 1
 * https://kalaiselvan369.medium.com/android-storage-scoped-storage-63949f8637e
 *
 * Parte 2
 * https://medium.com/swlh/android-file-storage-file-provider-5990c9baf52d
 */
class AndroidAndScopeStorageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_android_and_scope_storage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}