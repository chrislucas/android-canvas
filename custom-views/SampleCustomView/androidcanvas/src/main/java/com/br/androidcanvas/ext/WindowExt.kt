package com.br.androidcanvas.ext

import android.view.Window
import android.view.WindowManager

// https://developer.android.com/guide/topics/graphics/hardware-accel#determining
// fun View.isViewHardwareAccelerated() = isHardwareAccelerated
// fun Canvas.isCanvasHardwareAccelerated() = isHardwareAccelerated


fun Window.initHardwareAcceleration() = this.setFlags(
    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
)
