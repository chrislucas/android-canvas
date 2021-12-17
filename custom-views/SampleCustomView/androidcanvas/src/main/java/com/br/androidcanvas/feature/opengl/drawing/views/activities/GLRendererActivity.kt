package com.br.androidcanvas.feature.opengl.drawing.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.androidcanvas.R

/*
    Overview
    https://developer.android.com/training/graphics/opengl
    ------------------------------------

    https://developer.android.com/training/graphics/opengl/environment
 */
class GLRendererActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glrenderer)
    }
}