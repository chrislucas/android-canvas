package com.br.androidcanvas.feature.drawing.vertices.action

import com.br.classext.feature.builderbehavior.Behavior

interface Draw: Behavior {
    fun onDraw()
    fun onTouchEvent()
}