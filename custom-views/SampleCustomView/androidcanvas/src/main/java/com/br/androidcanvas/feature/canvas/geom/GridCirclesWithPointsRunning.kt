package com.br.androidcanvas.feature.canvas.geom

import android.content.Context
import android.util.AttributeSet
import android.view.View


/**
 * @see GridCircles
 * O mesmo desenho de grid de circulos com a adicao de que cada circulo
 * tem um ponto que percorre a aresta de cada ciruclo
 * https://en.wikipedia.org/wiki/Overlapping_circles_grid
 */
class GridCirclesWithPointsRunning @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

}