package com.xp.samplecustomview.feature.contentprovider.s1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xp.samplecustomview.R


/**
 * https://developer.android.com/guide/topics/providers/content-provider-basics?hl=pt-br
 * https://google-developer-training.github.io/android-developer-fundamentals-course-practicals/en/Unit%204/111a_p_implement_a_minimalist_content_provider.html
 * https://www.tutorialspoint.com/android/android_content_providers.htm
 * */


class BasicContentProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_content_provider)
    }
}