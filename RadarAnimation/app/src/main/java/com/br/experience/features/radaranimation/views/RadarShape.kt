package com.br.experience.features.radaranimation.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sin

class RadarShape @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    companion object {
        private const val ZERO_F = 0.0f
        private const val NINETY = 90.0f
    }

    private var midPoint = 0.0f

    private val path: Path = Path()

    private val alphaPaint = Paint()
    private val linePaint = Paint()

    private var angleRotation = 0
        set(value) {
            field = value % 360
        }

    private var degree = 0
    private var pulseRadius = 0.0f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        midPoint = max(width, height) / 2.0f
        path.addArc(ZERO_F, ZERO_F, width.toFloat(), height.toFloat(), -NINETY, NINETY)
        path.lineTo(width / 2.0f, width / 2.0f)
        increaseAngle()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        /**
         * https://proandroiddev.com/extraordinary-animations-using-trigonometry-and-coroutines-radar-animation-83c3605ac4d
         */
        with(canvas) {
            rotate(angleRotation.toFloat(), midPoint, midPoint)
            increaseAngle()

            drawPath(path, alphaPaint)
            drawLine(
                midPoint, midPoint, width.toFloat(), midPoint, linePaint
            )
            drawLine(
                midPoint, midPoint, midPoint, ZERO_F, linePaint
            )

            drawCircle(midPoint, midPoint, pulseRadius, alphaPaint)
        }
    }

    /**
     * O uso de coroutines para animacao e comum com compose, nesse tutorti
     */
    private fun increaseAngle() {
        CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                delay(10)
                angleRotation += 1
                degree += 1
                val sine = abs(sin(Math.toRadians(degree.toDouble())))
                pulseRadius = (width / 2.0f * sine).toFloat()
                invalidate()
            }
        }
    }
}