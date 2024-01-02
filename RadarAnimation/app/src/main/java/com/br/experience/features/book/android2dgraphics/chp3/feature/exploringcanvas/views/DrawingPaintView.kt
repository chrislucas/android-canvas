package com.br.experience.features.book.android2dgraphics.chp3.feature.exploringcanvas.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

/**
 * 20 drawPaint
 * https://medium.com/mobile-app-development-publication/learn-all-android-canvas-draw-functions-dd5d6595884a
 */
class DrawingPaintView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val gradientPaintDefault: Paint by lazy {
        Paint().also {
            it.shader = RadialGradient(
                width / 2.0f,       // center X
                height / 2.0f,      // center Y
                height / 2.0f,       // radius
                Color.BLACK,               // center color
                Color.GRAY,                // edge color
                Shader.TileMode.MIRROR
            )

        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPaint(gradientPaintDefault)
    }
}