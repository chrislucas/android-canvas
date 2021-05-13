package com.xp.samplecustomviews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.DragEvent
import android.view.View

class SampleCustomView : View {
    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }

    override fun onAnimationStart() {
        super.onAnimationStart()
    }

    override fun onAnimationEnd() {
        super.onAnimationEnd()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onDragEvent(event: DragEvent?): Boolean {

        event?.let {
            when(event.action) {
                DragEvent.ACTION_DRAG_STARTED ->
                    Log.i("DRAG_EVENT", "ACTION_DRAG_STARTED")
                else -> {
                    Log.i("DRAG_EVENT", "ELSE")
                }
            }
        }

        return true
    }
}