package com.xp.samplecustomview.feature.customviews.sample.behaviorcustomview.behavior.creator

import android.view.View
import android.widget.Toast
import com.br.classext.feature.builderbehavior.BuilderBehavior
import com.xp.samplecustomviews.feature.clickable.action.SimpleClickView

class CreateSimpleClickableView : BuilderBehavior {
    override fun build() = object : SimpleClickView {
        override fun onclick(view: View) {
            Toast.makeText(view.context, "SIMPLE ONCLICK", Toast.LENGTH_SHORT).show()
        }
    }
}