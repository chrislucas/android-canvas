package com.br.experience.features.drawingbasicshapes.canvas

import android.graphics.Canvas
import android.graphics.Paint
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import com.br.experience.features.drawingbasicshapes.views.RectCoordinate

/**
 * http://www.java2s.com/example/android/graphics/draw-arrow-on-canvas.html
 */

fun Canvas.drawArrow(rectCoordinate: RectCoordinate, paint: Paint) {
    with(this) {
        val (startX, startY) = rectCoordinate.first
        val (endX, endY) = rectCoordinate.second
        val dx = startX - endX
        val dy = startY - endY

        drawLine(startX, startY, endX, endY, paint)
    }
}