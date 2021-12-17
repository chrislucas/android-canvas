package com.br.androidcanvas.feature.opengl.drawing.vertices.action

import com.br.classext.feature.builderbehavior.Behavior

interface Draw: Behavior {
    fun onDraw()
    fun onTouchEvent()
}