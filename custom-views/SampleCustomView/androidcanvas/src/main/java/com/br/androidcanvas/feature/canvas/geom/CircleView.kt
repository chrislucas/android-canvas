package com.br.androidcanvas.feature.canvas.geom

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.br.androidcanvas.R

class CircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val mPaint : Paint = Paint()

    init {
        val attrs: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView)

    }
}