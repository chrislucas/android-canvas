package com.br.androidcanvas.ext

import android.graphics.Canvas
import android.view.View
import android.view.Window
import android.view.WindowManager

/*
    https://developer.android.com/guide/topics/graphics/hardware-accel#unsupported
 */

fun View.disableHardwareAcceleration() = this.setLayerType(View.LAYER_TYPE_HARDWARE, null)




