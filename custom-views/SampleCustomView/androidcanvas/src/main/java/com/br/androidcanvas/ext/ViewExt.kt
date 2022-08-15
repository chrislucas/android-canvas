package com.br.androidcanvas.ext

import android.view.View

/*
    https://developer.android.com/guide/topics/graphics/hardware-accel#unsupported
 */

fun View.disableHardwareAcceleration() = this.setLayerType(View.LAYER_TYPE_HARDWARE, null)




