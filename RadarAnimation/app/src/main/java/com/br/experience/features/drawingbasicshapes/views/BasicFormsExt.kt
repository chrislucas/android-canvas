package com.br.experience.features.drawingbasicshapes.views

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.graphics.Rect
import kotlin.math.sqrt

typealias RectCoordinate = Pair<PointF, PointF>


fun Canvas.drawLine(paint: Paint, p: PointF, q: PointF) {
    with(Path()) path@{
        moveTo(p.x, p.y)
        lineTo(q.x, q.y)
        close()
        this@drawLine.drawPath(this@path, paint)
    }
}

fun Canvas.drawCircle(coordinate: PointF, radius: Float, paint: Paint) {
    coordinate.let {
        drawCircle(it.x, it.y, radius, paint)
    }
}

fun Canvas.drawRect(
    coordinate: RectCoordinate,
    paint: Paint,
    createRect: (RectCoordinate) -> Rect
) {
    with(Rect(createRect(coordinate))) {
        this@drawRect.drawRect(this@with, paint)
    }
}

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

fun Canvas.drawSquare(
    coordinate: RectCoordinate,
    paint: Paint,
    createRect: (RectCoordinate) -> Rect
) {
    with(Rect(createRect(coordinate))) {
        this@drawSquare.drawRect(this, paint)
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

    canvas.drawSquare(rectCoordinate, paint) { coordinate ->
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

