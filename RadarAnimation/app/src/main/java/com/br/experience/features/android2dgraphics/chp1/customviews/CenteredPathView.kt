package com.br.experience.features.android2dgraphics.chp1.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.br.experience.features.drawingbasicshapes.views.RectCoordinate
import com.br.experience.features.drawingbasicshapes.views.drawPath

class CenteredPathView @JvmOverloads constructor
    (context: Context, attr: AttributeSet? = null, defAttrSet: Int = 0) : View(context, attr, defAttrSet) {

    private val paintCoordinate = Paint().also {
        it.color = Color.BLUE
    }

    private val paintPath = Paint().also {
        it.color = Color.BLACK
    }

    private var center = Pair(0, 0)
    private lateinit var coordinatePath: RectCoordinate


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        center = Pair(w, h)
        coordinatePath = RectCoordinate(
            PointF(0f, h / 2.0f), PointF(w * 1.0f, h / 2.0f)
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        /**
         * Path:
         */
        canvas.drawPath(paintPath, coordinatePath)
        val (x, y) = center
        canvas.drawText("C($x, $y)", x * 1.0f, (y * 1.0f) - 2.0f, paintCoordinate)
    }
}