package com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlin.math.atan2

/**
 * tutorial
 * https://blog.fossasia.org/making-bottomsheet-responsive-using-custom-gesture-detector-in-pslab-android-app/
 */
class SwipeDetector<V : View>(private val bottomSheetBehavior: BottomSheetBehavior<V>) :
    GestureDetector.SimpleOnGestureListener() {


    data class Point2f(val x: Double, val y: Double)

    enum class Direction {
        DOWN, TOP, LEFT, RIGHT
    }



    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {

        val p = Point2f(e1.x * 1.0, e1.y * 1.0)
        val q = Point2f(e2.x * 1.0, e2.y * 1.0)

        return when (direction(p, q)) {
             Direction.TOP -> {
                 bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                 true
             }
             Direction.DOWN -> {
                 if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                     bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                 }
                 true
             }
             Direction.LEFT, Direction.RIGHT -> {
                 true
             }
             else -> {
                 false
             }
         }
    }

    private fun direction(p: Point2f, q: Point2f): Direction {
        val (x1, y1) = p
        val (x2, y2) = q
        val angle = Math.toDegrees(atan2(y1 - y2, x1 - x2))

        return when {
            angle > 45 && angle <= 135 -> {
                Direction.TOP
            }

            angle >= 135 && angle <180 || angle < -135 && angle > -180 -> {
                Direction.LEFT
            }

            angle < -45 && angle >= -135 -> {
                Direction.DOWN
            }

            else -> {
                Direction.RIGHT
            }
        }
    }
}

