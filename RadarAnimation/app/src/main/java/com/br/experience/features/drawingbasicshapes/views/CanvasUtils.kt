package com.br.experience.features.drawingbasicshapes.views

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import kotlin.math.sqrt

object CanvasUtils {
    /*
    Exemplo retirado do link
    https://medium.com/android-news/android-canvas-for-drawing-and-custom-views-e1a3e90d468b
    para fins de estudo vou copia-lo e posteriormente modifica-lo,
    mas acima tem o link para dar o devido crédito
 */

    fun checkDrawRect(
        canvas: Canvas,
        radius: Float,
        rectCoordinate: RectCoordinate,
        paint: Paint
    ) {
        canvas.drawRect(rectCoordinate, paint) { coordinate ->
            val (p, q) = coordinate
            Rect(
                (p.x - .8f * radius).toInt(),
                (p.y - .6f * radius).toInt(),
                (q.x - .8f * radius).toInt(),
                (q.y - .6f * radius).toInt(),
            )
        }
    }

    /*
    Draw Square
    https://medium.com/android-news/android-canvas-for-drawing-and-custom-views-e1a3e90d468b
 */
    fun checkDrawSquare(
        canvas: Canvas,
        radius: Float,
        rectCoordinate: RectCoordinate,
        paint: Paint
    ) {

        canvas.drawSquare(paint, rectCoordinate) { coordinate ->
            val (p, q) = coordinate
            val squareSideHalf = 1.0 / sqrt(2.0)
            Rect(
                (p.x - squareSideHalf * radius).toInt(),
                (p.y - squareSideHalf * radius).toInt(),
                (q.x + squareSideHalf * radius).toInt(),
                (q.y + squareSideHalf * radius).toInt(),
            )
        }
    }
}