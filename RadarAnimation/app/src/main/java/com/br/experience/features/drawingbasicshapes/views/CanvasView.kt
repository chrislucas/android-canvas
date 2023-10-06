package com.br.experience.features.drawingbasicshapes.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.component1
import androidx.core.graphics.component2

/**
 * TODO
 * 1) adicionar bordas a essa view
 * 2) Estudar surfaceview
 */
class CanvasView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var center = PointF(width / 2f, height / 2f)

    private val paintCanvas = Paint().also {
        it.color = Color.BLACK
    }

    companion object {
        private const val RADIUS = 10
        private const val xFactor = 0.8
        private const val yFactor = 0.6

        private val fn: (RectCoordinate) -> Rect = { (p, q) ->
            val (px, py) = p
            val (qx, qy) = q
            Rect(
                (px - (xFactor * RADIUS)).toInt(),
                (py - (yFactor * RADIUS)).toInt(),
                (qx + (xFactor * RADIUS)).toInt(),
                (qy + (yFactor * RADIUS)).toInt()
            )
        }
    }

    private var canvas: Canvas? = null

    private val paintForDrawingGeometricForms = Paint().also {
        it.color = Color.RED
    }

    fun providerDefaultCircle() =
        DrawerCircle(
            center = PointF(center.x, center.y), radius = 3f
        )

     fun providerDefaultSquare() =
        DrawerSquare(
            RectCoordinate(
                PointF(center.x, center.y), PointF(center.x, center.y)
            ),
            paintForDrawingGeometricForms,
            fn
        )

    /**
     * baseado na funcao drawRectangle do link
     * https://medium.com/android-news/android-canvas-for-drawing-and-custom-views-e1a3e90d468b#fromHistory
     * TODO trocar os valores constantes por custom attrs na propria view
     */

    private var drawGeometricForm: DrawGeometricForm = providerDefaultSquare()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        this.canvas = canvas
        drawGeometricForm.draw(canvas)
    }

    fun setDrawGeometricForm(drawer: DrawGeometricForm) {
        drawGeometricForm = drawer
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        center = PointF(w / 2f, h / 2f)
    }

    fun drawTriangle() {
        drawGeometricForm = DrawerTriangle(paintForDrawingGeometricForms, center, 10)
        this.invalidate()
    }
}