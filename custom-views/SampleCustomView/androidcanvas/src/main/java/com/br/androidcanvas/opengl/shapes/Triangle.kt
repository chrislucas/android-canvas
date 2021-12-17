package com.br.androidcanvas.opengl.shapes

/**
 * https://developer.android.com/training/graphics/opengl/shapes
 * https://developer.android.com/training/graphics/opengl/draw
 */

class Triangle {
    val vertexShaderCode =
        listOf(
            listOf(
                "uniform mat4 uMVPMatrix;",
                "attribute vec4 vPosition;",
                "void main() {gl_Position = vPosition;}"
            ), listOf(
                "attribute vec4 vPosition;",
                "void main() {gl_Position = vPosition;}"
            )
        )


    val fragmentShaderCode =
        listOf(
            "precision mediump float;",
            "uniform vec4 vColor;",
            "void main() { gl_FragColor = vColor; }"
        )
}