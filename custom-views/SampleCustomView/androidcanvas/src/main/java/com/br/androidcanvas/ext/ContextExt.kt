package com.br.androidcanvas.ext

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowInsets
import android.view.WindowManager

fun Context.centerOfScreen(): Pair<Float, Float> {

    val windowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager

    /*
        https://stackoverflow.com/questions/63407883/
        getting-screen-width-on-api-level-30-android-11-getdefaultdisplay-and-getme
     */
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val windowMetrics = windowManager.currentWindowMetrics
        val windowsInsets = windowMetrics.windowInsets
        val insets =
            windowsInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
        windowMetrics.bounds.run {
            Pair(
                width() - insets.left - insets.right * .5f,
                height() - insets.top - insets.bottom * .5f
            )
        }
    } else {
        val displayMetric = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetric)
        Pair(displayMetric.widthPixels * .5f, displayMetric.heightPixels * .5f)
    }

}