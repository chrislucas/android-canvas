package br.com.xplorer.beziercurves.feature.beziercurve.customview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/*
    https://medium.com/@pranjalg2308/understanding-bezier-curve-in-android-and-moddinggraphview-library-a9b1f0f95cd0
 */
class BezierCurveView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var paint: Paint = Paint()
    private var path: Path = Path()

    var x1: Float = 0f
    var y1: Float = 0f
    var x2: Float = 0f
    var y2: Float = 0f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        with(paint) {
            style = Paint.Style.STROKE
            isAntiAlias = true
        }
        val w = this.width * 1.0f
        val h = this.height * 1.0f
        with(path) {
            moveTo(0.0f, 0.0f)
            cubicTo(x1, y1, x2, y2, w, h)
        }
        canvas?.drawPath(path, paint)
    }

}