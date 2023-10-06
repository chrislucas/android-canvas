package com.br.experience.features.android2dgraphics.chp1.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import com.br.experience.features.drawingbasicshapes.views.RectCoordinate
import com.br.experience.features.drawingbasicshapes.views.drawLine

/**
 *
 */
class CenteredLineView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paintCoordinate = Paint().also {
        with(it) {
            color = Color.BLUE
            textSize = 60f
            typeface = Typeface.create("serif", Typeface.BOLD)
        }
    }

    private val paintFreeText = Paint().also {
        with(it) {
            color = Color.RED
            textSize = 60f
            typeface = Typeface.create("serif", Typeface.BOLD)
        }
    }

    private val paintLine = Paint().also {
        with(it) {
            color = Color.BLACK
            style = Paint.Style.FILL_AND_STROKE
        }
    }

    private var dimension = Pair(0f, 0f)

    private lateinit var coordinateLine: RectCoordinate

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        dimension = Pair(w * 1.0f, h * 1.0f)
        coordinateLine = RectCoordinate(
            PointF(0f, h * .5f), PointF(w.toFloat(), h * .5f)
        )
    }

    override fun onDraw(canvas: Canvas) {

        with(canvas) {
            super.onDraw(this)
            drawLine(paintLine, coordinateLine)
            putDimensionText(this)
            putCenterText(this)
            putAFreeText(this)
        }
    }

    private fun putDimensionText(canvas: Canvas) {
        val (x, y) = dimension
        val dimensionDescription = "Dimension($x, $y)"
        canvas.drawText(
            dimensionDescription,
            getXOffset(paintCoordinate, dimensionDescription, x),
            y * .5f - 50f,
            paintCoordinate
        )
    }

    private fun putCenterText(canvas: Canvas) {
        val (x, y) = dimension
        val (cx, cy) = dimension.run { first * .5f to second * .5f }
        val centerDescription = "Center($cx, $cy)"
        canvas.drawText(
            centerDescription,
            getXOffset(paintCoordinate, centerDescription, x),
            y * .5f - 110f,
            paintCoordinate
        )
    }

    private fun putAFreeText(canvas: Canvas) {
        canvas.drawText("Um texto livre", 5.0f, 50.0f, paintFreeText)
    }

    private fun getXOffset(paint: Paint, text: String, drawingAreaWith: Float): Float {
        val measureTextPixel = paint.measureText(text)

        /*
            Explicando a conta

            se eu tenho 100px para desenhar algo
            e o meu texto ocupa 30px, para desenhar no centro
            eu preciso adicionar espaço a esquerda e a direita de forma proporcional.
            A conta é 100px - 30px = 70px
            Temos 70px para adicionar de espaço talque o texto de 30px fique no centro
            Então adicionamos metade desses 70 na esquerda e a outra na direita, 35px
            de cada lado
         */

        return (drawingAreaWith - measureTextPixel) * .5f - (paint.textSize * .5f)
    }
}