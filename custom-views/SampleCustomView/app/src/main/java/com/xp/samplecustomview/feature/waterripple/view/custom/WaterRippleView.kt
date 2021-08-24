package com.xp.samplecustomview.feature.waterripple.view.custom

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


/**
 * Explorando o codigo do link
 * https://www.programmersought.com/article/79564968988/
 * */

class Wave(
    var mWaveStartWidth: Double = 0.0,
    var mWaveEndWidth: Double = 0.0, var mWaveColor: Int = 0,
    var mMaxWaveAreaRadius: Double = 0.0,
    var mWaveIntervalSize: Double = 0.0
)

class WaterRippleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private var mStirStep = 0f  // indice de movimento
    private var mWidth = 0

    private var mViewCenterX = 0f
    private var mViewCenterY = 0f
    private val rippleColor = Color.BLUE

    private val mWavePaint = Paint()

    private val mWaveCenterShapePaint = Paint()
    private var mFillAllView = false
    private var mFillWaveSourceShapeRadius = 0f

    init {

    }
}