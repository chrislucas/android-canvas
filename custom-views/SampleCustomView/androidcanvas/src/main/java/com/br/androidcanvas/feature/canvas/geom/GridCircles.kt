package com.br.androidcanvas.feature.canvas.geom

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.br.androidcanvas.R
import com.br.androidcanvas.ext.CircleFloat
import com.br.androidcanvas.ext.SimplePoint2DF
import com.br.androidcanvas.ext.centerDistance
import com.br.androidcanvas.ext.intersect
import kotlin.math.min
import kotlin.math.sqrt


/*
    https://en.wikipedia.org/wiki/Overlapping_circles_grid
    https://medium.com/@brokyo/drawing-the-flower-of-life-22206fe36d02#30b7

    Criar um grid desenhando circulos
    O primeiro circulo deve ser desenhado no centro da tela
    o segundo deve ser desenhado partindo do centro do ulitmo circulo desenha (primeiro)
    o terceiro deve ser denhado a partir do centro do ultimo circulo desenhado (segundo)
    o i-esimo circulo sera desenhado a partir do centro do (i-1) - esimo ciruclo


    https://pt.stackoverflow.com/questions/260057/
    como-detectar-quais-s%C3%A3o-os-pontos-em-comum-entre-duas-circunfer%C3%AAncias

    Circles and spheres
    http://paulbourke.net/geometry/circlesphere/
 */


class GridCircles @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var center1stCircle: Pair<Float, Float> = Pair(.0F, .0F)
    private var center2ndCircle: Pair<Float, Float> = Pair(.0F, .0F)

    private var radiusEachCircle = 30.0f
    private var quantityOfCircle = 10

    private val pencilDrawingCircle = Paint(Paint.ANTI_ALIAS_FLAG)

    private val pencilDrawingDot = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        val mAttrs: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.GridCircles)

        if (mAttrs.hasValue(R.styleable.GridCircles_quantityCircles)) {
            quantityOfCircle = mAttrs.getInt(R.styleable.GridCircles_quantityCircles, 10)
        }

        if (mAttrs.hasValue(R.styleable.GridCircles_radiusEachCircle)) {
            radiusEachCircle = mAttrs.getFloat(R.styleable.GridCircles_radiusEachCircle, 30.0f)
        }

        pencilDrawingCircle.style = Paint.Style.STROKE
        pencilDrawingCircle.color = Color.BLUE
        mAttrs.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.run {
            var acc = 0
            pencilDrawingCircle.strokeWidth = 9.0f

            val (cx1, cy1) = center1stCircle
            val (cx2, cy2) = center2ndCircle
            // primeiro circulo e segunddo
            this.drawCircle(cx1, cy1, radiusEachCircle, pencilDrawingCircle)
            this.drawCircle(cx2, cy2, radiusEachCircle, pencilDrawingCircle)
            /**
             * https://www.obaricentrodamente.com/2011/06/interseccao-de-circunferencias.html#
             * https://mathworld.wolfram.com/Circle-CircleIntersection.html#
             *
             * Equacao
             * (x - pa) ^ 2 + (y - pb) ^ 2 = r^2
             * onde x e y é a coordenada no centro do circulo
             */

            val pair : Pair<SimplePoint2DF, SimplePoint2DF>? =
                intersection(center1stCircle, center2ndCircle, radiusEachCircle)

            pair?.let {
                (pc, _)  ->
                val (cx, cy) = pc
                this.drawCircle(cx, cy, radiusEachCircle, pencilDrawingCircle)
            }
        }
    }

    /**
     * Interseccao de circulos de mesmo raio
     */
    private fun intersection(pa: SimplePoint2DF, pb: SimplePoint2DF, radius: Float):
            Pair<SimplePoint2DF, SimplePoint2DF>? {
        val circle1 = CircleFloat(pa, radius)
        val circle2 = CircleFloat(pb, radius)

        if (circle1.intersect(circle2)) {
            val d = circle1.centerDistance(circle2)
            val distance = d * d / (2.0f * d)
            val half = sqrt(radius * radius - distance*distance)

            val dx = pb.first - pa.first
            val dy = pb.second - pa.second
            val midX = pa.first + (half * dx) / distance
            val midY = pa.second + (half * dy) / distance

            val x3 = (midX +  (half * dy) / distance).toFloat()
            val y3 = (midY -  (half * dx) / distance).toFloat()
            val pc = SimplePoint2DF(x3, y3)

            val x4 = (midX -  (half * dy) / distance).toFloat()
            val y4 = (midY +  (half * dx) / distance).toFloat()
            val pd = SimplePoint2DF(x4, y4)

            return Pair(pc, pd)
        }

        return null

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        center1stCircle = Pair(w * .5f, h * .5f)
        center2ndCircle = Pair(center1stCircle.first + radiusEachCircle, center1stCircle.second)
        radiusEachCircle = min(w, h) * .1f
    }
}