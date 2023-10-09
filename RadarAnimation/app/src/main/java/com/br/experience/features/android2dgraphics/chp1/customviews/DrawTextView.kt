package com.br.experience.features.android2dgraphics.chp1.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

/**
 * chp 1 - Book android 2d graphics with canvas api
 */
class DrawTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var dimension = Pair(0, 0)

    private val paintDrawText = Paint().apply {
        color = Color.BLACK
        textAlign = Paint.Align.CENTER
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        dimension = Pair(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val (w, h) = dimension
        paintDrawText.textSize = min(w, h) * .12f
        canvas.drawText("W=$w, H=$h", w * .5f, h * .5f, paintDrawText)
    }
}