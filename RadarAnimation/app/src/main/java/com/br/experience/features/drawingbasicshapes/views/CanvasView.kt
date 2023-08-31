package com.br.experience.features.drawingbasicshapes.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CanvasView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint =
        Paint().also {
            it.color = Color.BLUE
            it.isAntiAlias = true
            it.strokeWidth = 5.0f
            it.style = Paint.Style.FILL_AND_STROKE
            it.strokeJoin = Paint.Join.ROUND
            it.strokeCap = Paint.Cap.ROUND
        }


    private var canvas: Canvas? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        this.canvas = canvas
    }
}