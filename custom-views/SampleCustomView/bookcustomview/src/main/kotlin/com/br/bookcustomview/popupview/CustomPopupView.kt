package com.br.bookcustomview.popupview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.PopupWindow

class CustomPopupView : PopupWindow {

    constructor(context: Context) : this(context, null)

    constructor(
        context: Context,
        attrs: AttributeSet?,
    ) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(view: View, w: Int, h: Int) : super(view, w, h)


    fun showAtLocation(anchorView: View, offsetLocation: OffsetLocation) {
        super.showAtLocation(
            anchorView,
            offsetLocation.gravityAlignment,
            offsetLocation.xOffset,
            offsetLocation.yOffset
        )
    }

}

data class OffsetLocation(val xOffset: Int, val yOffset: Int, val gravityAlignment: Int)