package com.xp.samplecustomviews.feature.clickable.action

import android.view.View

class DumbBehaviorCustomView : SimpleClickView {

    override fun onclick(view: View) {
        println("It'' me")
    }
}