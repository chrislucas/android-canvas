package com.br.androidcanvas.ext

import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin


fun Double.toRadians() = this * PI / 180

fun Double.toDegree() = this * 180 / PI

fun getPositionOnCircle(radius: Float, angleTheta: Double, center: Pair<Float, Float>) =
    Pair(
        center.first + radius * cos(angleTheta.toRadians()),
        center.second + radius * sin(angleTheta.toRadians())
    )

/*
    funcao atan2 - Arco Tangente
 */

fun angleBetweenTwoLines(
    center: Pair<Double, Double>,
    pa: Pair<Double, Double>,
    pb: Pair<Double, Double>
): Double {
    val a1 = atan2(pa.second - center.second, pa.first - center.first)
    val a2 = atan2(pb.second - center.second, pb.first - center.first)

    return a1 - a2
}