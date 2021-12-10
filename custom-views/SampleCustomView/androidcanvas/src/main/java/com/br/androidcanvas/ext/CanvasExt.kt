package com.br.androidcanvas.ext

import android.graphics.Canvas
import android.graphics.Paint


fun Canvas.simplestDrawingVertices(
    vertexMode: Canvas.VertexMode,
    vertexCountOffset: Int,
    vertices: FloatArray,
    color: IntArray,
    paint: Paint = Paint()
) {
    this.drawVertices(
        vertexMode,
        vertices.size,
        vertices,
        vertexCountOffset,
        null,
        0,
        color,
        0,
        null,
        0,
        0,
        paint
    )
}