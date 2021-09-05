package com.xp.samplecustomviews.feature.clickable

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.DragEvent
import android.view.View
import com.br.classext.Behavior
import com.br.classext.fromClassNameToCreateBehavior
import com.xp.samplecustomviews.R
import com.xp.samplecustomviews.feature.clickable.action.SimpleClickView

class ClickableView : View {
    private var mBehavior: Behavior? = null


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initBehavior(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initBehavior(context, attrs)
    }

    private fun initBehavior(ctx: Context?, attrs: AttributeSet?) {
        val styledAttrs: TypedArray? = ctx?.obtainStyledAttributes(attrs, R.styleable.ClickableView)

        val hasAttr = styledAttrs?.hasValue(R.styleable.ClickableView_classCreateBehavior) ?: false

        if (hasAttr) {
            mBehavior = styledAttrs?.getString(R.styleable.ClickableView_classCreateBehavior)
                ?.fromClassNameToCreateBehavior()
        }

        this.setOnClickListener {
            mBehavior?.let {
                if (it is SimpleClickView) {
                    it.onclick(this)
                }
            }
        }
        styledAttrs?.recycle()
    }

    override fun callOnClick(): Boolean {
        return super.callOnClick()
    }

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
            when (event.action) {
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