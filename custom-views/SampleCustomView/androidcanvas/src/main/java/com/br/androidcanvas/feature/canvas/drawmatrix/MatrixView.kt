package com.br.androidcanvas.feature.canvas.drawmatrix

import android.content.Context
import android.util.AttributeSet
import android.view.View

class MatrixView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    val leftBracketView: BracketView = BracketView(context, attrs, defStyleAttr)
    val rightBracketView: BracketView = BracketView(context, attrs, defStyleAttr)

}