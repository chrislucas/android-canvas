package com.br.androidcanvas.feature.canvas.geom

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.br.androidcanvas.R
import kotlin.math.min


/*
    https://en.wikipedia.org/wiki/Overlapping_circles_grid
    https://medium.com/@brokyo/drawing-the-flower-of-life-22206fe36d02#30b7

    Criar um grid desenhando circulos
    O primeiro circulo deve ser desenhado no centro da tela
    o segundo deve ser desenhado partindo do centro do ulitmo circulo desenha (primeiro)
    o terceiro deve ser denhado a partir do centro do ultimo circulo desenhado (segundo)
    o i-esimo circulo sera desenhado a partir do centro do (i-1) - esimo ciruclo
 */
class GridCircles @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private var centerOfLastCircle: Pair<Float, Float>? = null //= context.centerOfScreen()

    private var radiusEachCircle = 30.0f
    private var quantityOfCircle = 10

    private val pencilDrawingCircle = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        val mAttrs: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.GridCircles)

        if (mAttrs.hasValue(R.styleable.GridCircles_quantityCircles)) {
            quantityOfCircle = mAttrs.getInt(R.styleable.GridCircles_quantityCircles, 10)
        }

        if (mAttrs.hasValue(R.styleable.GridCircles_radiusEachCircle)) {
            radiusEachCircle = mAttrs.getFloat(R.styleable.GridCircles_radiusEachCircle, 30.0f)
        }

        pencilDrawingCircle.style = Paint.Style.STROKE
        pencilDrawingCircle.color = Color.BLUE //0xff00099
        mAttrs.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.run {
            var acc = 0
            centerOfLastCircle?.let {
                var (cx, cy) = it
                pencilDrawingCircle.strokeWidth = 9.0f
                do {
                    this.drawCircle(cx, cy, radiusEachCircle, pencilDrawingCircle)
                    if(acc % 4 == 0) {
                        cx -= radiusEachCircle
                        cy += radiusEachCircle
                    }
                    else {
                        cx += radiusEachCircle
                        cy -= radiusEachCircle
                    }

                    acc += 1
                } while (acc < quantityOfCircle)
            }
        }
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerOfLastCircle = Pair(w * .5f, h * .5f)
        radiusEachCircle = min(w, h) * .1f
    }
}