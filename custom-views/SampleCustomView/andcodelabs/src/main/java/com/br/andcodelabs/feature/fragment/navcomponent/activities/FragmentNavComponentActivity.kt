package com.br.andcodelabs.feature.fragment.navcomponent.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.andcodelabs.R


/**
 * https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component#0
 * */

class FragmentNavComponentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
    }
}