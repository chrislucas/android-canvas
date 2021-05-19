package com.experience.bookcustomview

import android.content.Context
import android.util.AttributeSet
import android.view.View


class SimpleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    /**
     * O sistema nos fornece 3 modos de como a view parent indica a sua view
     * como ela deve calcular suas dimensoes
     *        MeasureSpec.AT_MOST
     *          a view em questao (child) tem uma certa flexivilidade para controlar o seu tamanho
     *          aumentando-o ou diminuindo-o, entretanto ela so pode expandir ate o tamanho ja pre
     *          estabelecido
     *        MeasureSpec.EXACTLY
     *            a view parent calcula o tamanho da child
     *        MeasureSpec.UNSPECIFIED
     *          podemos controlar o tamanho da view para o tamanho que quisermos ou o necessario
     * */

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        logDimension(widthMeasureSpec, heightMeasureSpec)
    }


    private fun logDimension(widthMeasureSpec: Int, heightMeasureSpec: Int): String =
        String.format(
            "[%s, %s]",
            MeasureSpec.toString(widthMeasureSpec),
            MeasureSpec.toString(heightMeasureSpec)
        )

}