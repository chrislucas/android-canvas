package com.br.androidcanvas.feature.canvas.geom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import com.br.androidcanvas.ext.SimplePoint2DF


/**
 * Redesenhar um circulo conforme tocamos a tela. O ponto que tocarmos deevera ser o novo centro do
 * circulo
 */
class DraggableCircleView1st @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var centerOfCircle = SimplePoint2DF(0.0f, 0.0f)
    val pencilDrawCircle = Paint(Paint.ANTI_ALIAS_FLAG)

    /**
     * https://medium.com/@supahsoftware/custom-android-views-drag-and-drop-5e9327a2af59
     * https://developer.android.com/guide/topics/ui/drag-drop
     */

    override fun onDragEvent(event: DragEvent?): Boolean {
        return super.onDragEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.run {

        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerOfCircle = SimplePoint2DF(w * .5f, h *.5f)
    }


}