package com.br.experience.features.drawingbasicshapes.views

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.graphics.Rect
import android.graphics.RectF
import androidx.core.graphics.component1
import androidx.core.graphics.component2

typealias RectCoordinate = Pair<PointF, PointF>

fun Canvas.drawPath(paint: Paint, p: PointF, q: PointF) {
    with(Path()) path@{
        moveTo(p.x, p.y)
        lineTo(q.x, q.y)
        close()
        this@drawPath.drawPath(this@path, paint)
    }
}

fun Canvas.drawPath(paint: Paint, coordinate: RectCoordinate): Path =
    Path().apply path@{
        val (p, q) = coordinate
        moveTo(p.x, p.y)
        lineTo(q.x, q.y)
        this@drawPath.drawPath(this@path, paint)
    }

fun Canvas.drawPath(paint: Paint, coordinates: List<RectCoordinate>) {
    with(Path()) path@{
        coordinates.forEach { (p, q) ->
            moveTo(p.x, p.y)
            lineTo(q.x, q.y)
        }
        close()
        this@drawPath.drawPath(this@path, paint)
    }
}

fun Canvas.drawLine(paint: Paint, coordinate: RectCoordinate) {
    /**
     * From book android 2d graphic
     */
    with(this) {
        val (p, q) = coordinate
        drawLine(p.x, p.y, q.x, q.y, paint)
    }
}

fun Canvas.drawCircle(coordinate: PointF, radius: Float, paint: Paint) {
    coordinate.let {
        val (x, y) = it
        drawCircle(x, y, radius, paint)
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

fun Canvas.drawSquare(
    paint: Paint,
    coordinate: RectCoordinate,
    createRect: (RectCoordinate) -> Rect
) {
    with(createRect(coordinate)) {
        /**
         * drawRect(
         *      Rect(startX, topY, endX, bottomY)
         * )
         * topo esquerdo(sX, tY);  topo direito(eX, tY)
         * Baixo esquerdo(sY, bY); baixo direito(eX, bY)
         */
        this@drawSquare.drawRect(this, paint)
    }
}

fun Canvas.drawRoundedRect(
    paint: Paint,
    coordinate: RectCoordinate,
    radiusEdge: PointF,
    createRect: (RectCoordinate) -> RectF
) {
    createRect(coordinate).run {
        drawRoundRect(this, radiusEdge.x, radiusEdge.y, paint)
    }
}

fun Canvas.drawTriangle(paint: Paint, center: PointF, width: Int) {
    /*
        Getting tougher : Draw Triangle ()
        https://medium.com/android-news/android-canvas-for-drawing-and-custom-views-e1a3e90d468b#fromHistory

        Encontre 3 vertices e conecte-os com linhas

        h = metade do comprimento da aresta do triangulo
        p (x, y-h)
        q (x-h, y)
        s (x+h, y+h)
     */
    val h = width / 2
    with(Path()) {
        val (x, y) = center
        moveTo(x, y - h)    // top
        lineTo(x - h, y + h)    // bottom left
        lineTo(x + h, y - h)    // bottom right
        lineTo(x, y - h)    // bback to the top
        close()
        this@drawTriangle.drawPath(this@with, paint)
    }
}


fun Canvas.writeText(text: String, coordinate: PointF, paint: Paint) {
    coordinate.let { (x, y) ->
        drawText(text, x, y, paint)
    }
}

interface DrawGeometricForm {
    fun draw(canvas: Canvas)
}

class DrawerCircle(
    private val center: PointF,
    private val paint: Paint =
        Paint().also {
            it.color = Color.BLUE
            it.isAntiAlias = true
            it.strokeWidth = 2.0f
            it.style = Paint.Style.FILL_AND_STROKE
            it.strokeJoin = Paint.Join.ROUND
            it.strokeCap = Paint.Cap.ROUND
        },
    private val radius: Float
) : DrawGeometricForm {
    override fun draw(canvas: Canvas) {
        canvas.drawCircle(center, radius, paint)
    }
}

class DrawerSquare(
    private val rectCoordinate: RectCoordinate,
    private val paint: Paint,
    private val createRect: (RectCoordinate) -> Rect = { Rect() }
) : DrawGeometricForm {
    override fun draw(canvas: Canvas) {
        canvas.drawSquare(paint, rectCoordinate, createRect)
    }
}

class DrawerPath(
    private val paint: Paint, private val coordinates: List<RectCoordinate>
) : DrawGeometricForm {
    override fun draw(canvas: Canvas) {
        canvas.drawPath(paint, coordinates)
    }
}

class DrawerTriangle(
    private val paint: Paint, private val center: PointF, private val width: Int
) : DrawGeometricForm {
    override fun draw(canvas: Canvas) {
        canvas.drawTriangle(paint, center, width)
    }
}

class DrawerLine(
    private val paint: Paint,
    private val startAndEndCoordinate: RectCoordinate?
) : DrawGeometricForm {

    constructor(paint: Paint) : this(paint, null)

    override fun draw(canvas: Canvas) {
        startAndEndCoordinate?.let {
            canvas.drawLine(paint, it)
        }
    }

    fun draw(canvas: Canvas, coordinates: FloatArray) {
        canvas.drawLines(coordinates, paint)

        listOf<Float>().toFloatArray()
    }

    fun draw(canvas: Canvas, coordinates: List<RectCoordinate>) {

        coordinates.flatMapTo(mutableListOf()) { (p, q) ->
            mutableListOf(p.x, p.y, q.x, q.y)
        }.toFloatArray().let {
            canvas.drawLines(it, paint)
        }
    }
}

class DrawerPoint(
    private val paint: Paint,
    private val coordinate: PointF
) : DrawGeometricForm {
    override fun draw(canvas: Canvas) {
        canvas.drawPoint(coordinate.x, coordinate.y, paint)
    }

    fun drawPoints(canvas: Canvas, points: List<PointF>) {
        points.flatMapTo(mutableListOf()) { point ->
            mutableListOf(point.x, point.y)
        }.toFloatArray().let {
            canvas.drawPoints(it, paint)
        }
    }
}





