package com.br.androidcanvas.ext

import android.graphics.Canvas
import android.graphics.Paint

fun Canvas.simpleDrawingVertices(
    vertexMode: Canvas.VertexMode,
    vertexCountOffset: Int,
    vertexCount: Int,
    vertices: FloatArray,
    paint: Paint = Paint()
) {
    this.drawVertices(
        vertexMode,
        vertexCount,
        vertices,
        vertexCountOffset,
        null,
        0,
        null,
        0,
        null,
        0,
        0,
        paint
    )
}