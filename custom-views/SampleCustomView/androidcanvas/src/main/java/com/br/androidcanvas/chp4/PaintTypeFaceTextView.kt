package com.br.androidcanvas.chp4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View


/**
 * Definicao de termos
 *
 * Usualmente Typeface refere-se a um design como Times New Roman or Palatino
 * e fonts sao implementacoes de design como, TrueType, OpenType ou fontes de
 * PostScript Times New Roman Typeface
 *
 */
class PaintTypeFaceTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        textSize = 30.0f
    }

    private var cx = 0.0f
    private var cy = 0.0f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.typeface = Typeface.DEFAULT
        canvas?.run {
            var y = 90.0f
            drawText("DEFAULT ($cx, $y)", cx, y, mPaint)

            y += 90.0f
            mPaint.typeface = Typeface.DEFAULT_BOLD
            drawText("DEFAULT_BOLD ($cx, $y)", cx, y, mPaint)

            y += 90.0f
            mPaint.typeface = Typeface.SANS_SERIF
            drawText("SANS_SERIF ($cx, $y)", cx, y, mPaint)

            y += 90.0f
            mPaint.typeface = Typeface.SERIF
            drawText("SERIF ($cx, $y)", cx, y, mPaint)

            y += 90.0f
            mPaint.typeface = Typeface.MONOSPACE
            drawText("MONOSPACE ($cx, $y)", cx, y, mPaint)

            val serifItalic = Typeface.create(
                "serif",
                Typeface.ITALIC
            )

            y += 90.0f
            mPaint.typeface = serifItalic
            drawText("SERIF_ITALIC ($cx, $y)", cx, y, mPaint)

            val serifBoldItalic = Typeface.create(
                "serif",
                Typeface.BOLD_ITALIC
            )

            y += 90.0f
            mPaint.typeface = serifBoldItalic
            drawText("SERIF_BOLD_ITALIC ($cx, $y)", cx, y, mPaint)

            val serifBold = Typeface.create(
                "serif",
                Typeface.BOLD
            )

            y += 90.0f
            mPaint.typeface = serifBold
            drawText("SERIF_BOLD ($cx, $y)", cx, y, mPaint)

            val serifNormal = Typeface.create(
                "serif",
                Typeface.NORMAL
            )

            y += 90.0f
            mPaint.typeface = serifNormal
            drawText("SERIF_NORMAL ($cx, $y)", cx, y, mPaint)

            val sansSerifItalic = Typeface.create(
                "sans-serif",
                Typeface.ITALIC
            )

            y += 90.0f
            mPaint.typeface = sansSerifItalic
            drawText("SANS_SERIF_ITALIC ($cx, $y)", cx, y, mPaint)


            val sansSerifNormal = Typeface.create(
                "sans-serif",
                Typeface.NORMAL
            )

            y += 90.0f
            mPaint.typeface = sansSerifNormal
            drawText("SANS_SERIF_NORMAL ($cx, $y)", cx, y, mPaint)


            val sansSerifBold = Typeface.create(
                "sans-serif",
                Typeface.BOLD
            )

            y += 90.0f
            mPaint.typeface = sansSerifBold
            drawText("SANS_SERIF_BOLD ($cx, $y)", cx, y, mPaint)


            val sansSerifBoldItalic = Typeface.create(
                "sans-serif",
                Typeface.BOLD_ITALIC
            )

            y += 90.0f
            mPaint.typeface = sansSerifBoldItalic
            drawText("SANS_SERIF_BOLD_ITALIC ($cx, $y)", cx, y, mPaint)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        cx = w * .5f
        cy = h * .5f
    }
}