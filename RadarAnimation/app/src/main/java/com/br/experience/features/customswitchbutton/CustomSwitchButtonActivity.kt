package com.br.experience.features.customswitchbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.R

/**
 * https://blog.appcircle.io/article/how-to-customize-the-switch-button-in-android
 * https://developer.android.com/reference/android/widget/Switch
 * https://www.geeksforgeeks.org/how-to-create-custom-switch-button-in-android/
 */
class CustomSwitchButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_switch_button)
    }
}