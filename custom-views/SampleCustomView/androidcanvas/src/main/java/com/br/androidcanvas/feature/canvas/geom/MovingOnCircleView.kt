package com.br.androidcanvas.feature.canvas.geom

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.br.androidcanvas.ext.angleBetweenTwoLines
import com.br.androidcanvas.ext.centerOfScreen
import com.br.androidcanvas.ext.toDegree

/*
    https://stackoverflow.com/questions/7708246/android-moving-an-object-in-circle
 */

class MovingOnCircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var center = Pair(.0f, .0f)

    private val centerOfScreen: Pair<Float, Float>
        get() = context.centerOfScreen()

    var startPosition: Pair<Double, Double> = Pair(0.0, 0.0)

    val mPaintTextAngle = Paint()

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        /*
            https://developer.android.com/training/gestures/movement
         */

        event?.run {

            /*
                https://stackoverflow.com/questions/6919292/pointerindex-out-of-range-android-multitouch
             */
            val pointerIndex = (action and MotionEvent.ACTION_POINTER_INDEX_MASK)
                .shr(MotionEvent.ACTION_POINTER_INDEX_SHIFT)

            val pointerId = this.getPointerId(pointerIndex)
            /*
                https://stackoverflow.com/questions/3476779/how-to-get-the-touch-position-in-android

               java.lang.IllegalArgumentException: pointerIndex out of range
                at android.view.MotionEvent.nativeGetRawAxisValue(Native Method)
                at android.view.MotionEvent.getRawX(MotionEvent.java:2695)
                at com.br.androidcanvas.feature.canvas.geom.MovingOnCircleView
                .onTouchEvent(MovingOnCircleView.kt:51)

                Essa custom view esta sendo usada dentro de um fragment que esta numa ViewPager
                e aparentemente esta ocorrendo um conflito entre o evento de touch da
                viewpager e o touch nessa custom view
             */
            val currentPosition: Pair<Pair<Double, Double>, Int> =
                Pair(rawX.toDouble() to rawY.toDouble(), pointerId)

            /*
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Pair(
                        getRawX(pointerId).toDouble() to getRawY(pointerId).toDouble(),
                        pointerId
                    )
                } else {
                    Pair(rawX.toDouble() to rawY.toDouble(), pointerId)
                }

             */

            when (this.actionMasked) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP -> {
                    startPosition = currentPosition.first
                }

                MotionEvent.ACTION_MOVE -> {
                    val mCenter = centerOfScreen.run {
                        val (cx, cy) = this
                        cx.toDouble() to cy.toDouble()
                    }
                    val angle = angleBetweenTwoLines(mCenter, startPosition, currentPosition.first)
                    if (Log.isLoggable("ANGLE_RADIANS_DEGREE", Log.INFO)) {
                        Log.i(
                            "ANGLE_RADIANS_DEGREE",
                            String.format(
                                "Position: %s | Radians: %.8f | Degree: (%.8f, %.8f)",
                                currentPosition,
                                angle,
                                angle.toDegree(),
                                Math.toDegrees(angle)
                            )
                        )
                    }
                }
                else -> {
                    // NOTHING
                }
            }
        }
        return true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        center = Pair(w / 2.0f, h / 2.0f)
    }
}