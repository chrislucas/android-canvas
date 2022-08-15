package com.br.androidcanvas.ext

import kotlin.math.*

typealias SimplePoint2DF = Pair<Float, Float>

data class CircleFloat(val center: SimplePoint2DF, val radius: Float)

fun Double.almostEquals(p: Double, eps: Double = 10E-6) =
    abs(p - this) < eps

fun Float.almostEquals(p: Float, eps: Float = 10E-6f) = abs(p - this) < eps

fun CircleFloat.intersect(that: CircleFloat): Boolean {
    val distance = this.center.eDistance(that.center)
    val sum = (this.radius + that.radius) * 1.0
    val diff = (this.radius - that.radius) * 1.0
    return distance.almostEquals(sum) || distance.almostEquals(diff)
}

fun CircleFloat.external(that: CircleFloat): Boolean {
    val distance = this.center.eDistance(that.center)
    val sum = (radius + that.radius) * 1.0
    return distance == sum
}

fun CircleFloat.internal(that: CircleFloat): Boolean {
    val distance = this.center.eDistance(that.center)
    val sum = (radius - that.radius) * 1.0
    return distance == sum
}

fun CircleFloat.secant(that: CircleFloat): Boolean {
    val distance = this.center.eDistance(that.center)
    val sum = (radius + that.radius) * 1.0
    return distance < sum
}

fun CircleFloat.centerDistance(that: CircleFloat) = this.center.eDistance(that.center)


fun SimplePoint2DF.eDistance(that: SimplePoint2DF): Double {
    val (x1, y1) = this
    val (x2, y2) = that
    val s = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1) )
    return sqrt(s * 1.0)
}

fun SimplePoint2DF.centerPoint(that: SimplePoint2DF): SimplePoint2DF {
    return SimplePoint2DF((that.first + first) / 2.0f, (that.second + second) / 2.0f)
}

operator fun SimplePoint2DF.minus(that: SimplePoint2DF) =
    SimplePoint2DF(first - that.first, second - that.second)

operator fun SimplePoint2DF.plus(that: SimplePoint2DF) =
    SimplePoint2DF(first + that.first, second + that.second)

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