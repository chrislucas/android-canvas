package com.xp.samplecustomview.feature.checkapplifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xp.samplecustomview.R


/**
 * https://developer.android.com/reference/android/app/Application
 * https://guides.codepath.com/android/Understanding-the-Android-Application-Class
 * https://www.sciencedirect.com/topics/computer-science/android-application
 * */
class ApplicationLifecycleCallbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appication_lifecycle_callback)
    }
}