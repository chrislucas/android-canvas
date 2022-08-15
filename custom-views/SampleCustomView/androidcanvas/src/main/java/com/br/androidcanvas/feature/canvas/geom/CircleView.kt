package com.br.androidcanvas.feature.canvas.geom

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.br.androidcanvas.R
import com.br.androidcanvas.ext.centerOfScreen
import kotlin.math.min

class CircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val mPaint: Paint = Paint()

    private var centerXY = Pair(0.0f, 0.0f)
    private var radius = 0.0f

    private val centerOfScreen: Pair<Float, Float>
        get() = context.centerOfScreen()


    init {
        val attrs: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView)
        setPaintColor(attrs)
        setStrokeWidthPaint(attrs)
        setPaintStyle(attrs)
        setAntiAlias(attrs)
        setDither(attrs)
        attrs.recycle()
    }

    private fun setPaintColor(attrs: TypedArray) {
        val attrBorderColor = attrs.hasValue(R.styleable.CircleView_borderColor)
        if (attrBorderColor) {
            mPaint.color = attrs.getColor(
                R.styleable.CircleView_borderColor,
                ContextCompat.getColor(context, R.color.transparent)
            )
        }
    }

    private fun setStrokeWidthPaint(attrs: TypedArray) {
        val attrStrokeWidthPaint = attrs.hasValue(R.styleable.CircleView_strokeWidthView)
        val defaultStroke = 30.0f
        if (attrStrokeWidthPaint) {
            mPaint.strokeWidth =
                attrs.getFloat(R.styleable.CircleView_strokeWidthView, defaultStroke)
        } else {
            mPaint.strokeWidth = defaultStroke
        }
    }

    private fun setPaintStyle(attrs: TypedArray) {
        val attrPaintStyle = attrs.hasValue(R.styleable.CircleView_paintStyle)
        if (attrPaintStyle) {
            val mapPaintStyle = mapOf(
                0 to Paint.Style.FILL,
                1 to Paint.Style.STROKE,
                2 to Paint.Style.FILL_AND_STROKE
            )
            mPaint.style = mapPaintStyle[attrs.getInt(R.styleable.CircleView_paintStyle, 1)]
        } else {
            mPaint.style = Paint.Style.STROKE
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerXY = Pair(w / 2.0f, h / 2.0f)
        radius = min(w, h) * .7f * .5f
    }

    private fun setAntiAlias(attrs: TypedArray) {
        val attrAntiAlias = attrs.hasValue(R.styleable.CircleView_android_antialias)
        if (attrAntiAlias) {
            mPaint.isAntiAlias = attrs.getBoolean(R.styleable.CircleView_android_antialias, true)
        }
    }

    private fun setDither(attrs: TypedArray) {
        val attrDither = attrs.hasValue(R.styleable.CircleView_android_dither)
        if (attrDither) {
            mPaint.isDither = attrs.getBoolean(R.styleable.CircleView_android_dither, true)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.i("CENTER", "$centerXY")
        Log.i("CENTER", "$centerOfScreen")
        canvas?.run {
            val (x, y) = centerXY
            this.drawCircle(x, y, radius, mPaint)
        }
    }
}