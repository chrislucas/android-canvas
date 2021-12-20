package com.br.androidcanvas.opengl.shapes

import android.opengl.GLSurfaceView
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/*
    https://developer.android.com/training/graphics/opengl/draw
 */

class CustomGLRenderer: GLSurfaceView.Renderer {


    private val mTriangle: Triangle by lazy { Triangle() }
    private val mSquare: Square by lazy { Square() }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {

    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {

    }

    override fun onDrawFrame(gl: GL10?) {

    }
}