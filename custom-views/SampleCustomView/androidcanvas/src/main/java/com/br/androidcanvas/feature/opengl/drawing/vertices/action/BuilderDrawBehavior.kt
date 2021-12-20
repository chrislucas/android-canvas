package com.br.androidcanvas.feature.opengl.drawing.vertices.action

import com.br.classext.feature.builderbehavior.Behavior
import com.br.classext.feature.builderbehavior.BuilderBehavior

class BuilderDrawBehavior : BuilderBehavior {
    override fun build(): Behavior = object : Draw {
        override fun onDraw() {}

        override fun onTouchEvent() {}

    }
}