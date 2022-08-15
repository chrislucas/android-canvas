package com.br.androidcanvas.feature.canvas.geom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View

/*
    https://stackoverflow.com/questions/42085507/android-how-to-draw-circle-within-two-point
 */

class CircleViewWithPath @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var center: Pair<Float, Float> = 0.0f to 0.0f
    private val path = Path()
    private val pencilDrawingCircle = Paint(Paint.ANTI_ALIAS_FLAG)

    init {

        pencilDrawingCircle.style = Paint.Style.STROKE
        pencilDrawingCircle.color = Color.BLUE
    }


    override fun onDragEvent(event: DragEvent?): Boolean {
        return super.onDragEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.run {
            center.let { (cx, cy) ->
                path.addCircle(cx, cy, 30.0f, Path.Direction.CCW)
            }
            this.drawPath(path, pencilDrawingCircle)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        center = w * .5f to h * .5f
    }
}