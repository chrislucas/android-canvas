package com.br.androidcanvas.chp4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MapTypefaceTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        textSize = 40.0f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.run {
            var y = 90.0f
            for ((fontFamily, typefaces) in mapFontAndTypefaces) {
                for (typeface in typefaces) {
                    mPaint.typeface = typeface
                    drawText(
                        "$fontFamily-${mapTypefaces[typeface.style]}",
                        40.0f, y, mPaint
                    )
                    y += 50.0f
                }
                y += 90.0f
            }
        }
    }
}