package com.xp.samplecustomviews.feature.clickable.action

import android.view.View
import com.br.classext.feature.builderbehavior.Behavior

interface SimpleClickView : Behavior {
    fun onclick(view: View)
}