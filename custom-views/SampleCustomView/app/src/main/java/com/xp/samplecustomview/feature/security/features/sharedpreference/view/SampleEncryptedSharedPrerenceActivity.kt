package com.xp.samplecustomview.feature.security.features.sharedpreference.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xp.samplecustomview.R

/**
 * https://developer.android.com/reference/androidx/security/crypto/EncryptedSharedPreferences
 * TODO estudar sobre encriptacao e seguranca
 */
class SampleEncryptedSharedPrerenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_encrypted_shared_prerence)
    }
}