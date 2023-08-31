package com.br.experience.canvas.drawing.spiral

import kotlin.math.cos
import kotlin.math.sin

object MathUtils {

    /*
        plot x=cos(t)*t/10,y=sin(t)*t/10 for t=0..20pi
     */
    fun spiralValues(param: Double = 20 * Math.PI): List<Pair<Double, Double>> {
        var t = 0.0
        val values = mutableListOf<Pair<Double, Double>>()
        while (t < param) {
            values += Pair(cos(t) * t / 10.0, sin(t) * t / 10.0)
            t += 1.0
        }

        return values.toList()
    }
}