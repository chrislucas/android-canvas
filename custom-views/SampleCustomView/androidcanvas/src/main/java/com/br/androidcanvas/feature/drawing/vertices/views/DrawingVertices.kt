package com.br.androidcanvas.feature.drawing.vertices.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.br.androidcanvas.R
import com.br.androidcanvas.ext.simplestDrawingVertices

class DrawingVerticesView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val paint = Paint()
    var vertexMode = Canvas.VertexMode.TRIANGLES

    private val vertices = mutableListOf<Float>()


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (width == 0 || height == 0)
            return
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)

        canvas?.simplestDrawingVertices(
            vertexMode,
            0,
            vertices.toFloatArray(),
            vColor,
            paint
        )
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (vertices.size == 64) {
            Toast.makeText(
                context,
                context.getString(R.string.message_quantity_max_vertices)
                , Toast.LENGTH_SHORT).show()
            return false
        }

        event?.let {
            val pointerIndex = it.actionIndex

            return when(event.actionMasked) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> true
                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_POINTER_UP -> {
                    vertices.add(event.getX(pointerIndex))
                    vertices.add(event.getY(pointerIndex))
                    invalidate()
                    true
                }
                else -> {
                    false
                }
            }
        }

        return super.onTouchEvent(event)
    }

}