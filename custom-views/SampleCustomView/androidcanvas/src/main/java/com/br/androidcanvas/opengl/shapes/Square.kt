package com.br.androidcanvas.opengl.shapes

class Square {

    val vertexShaderCode =
        listOf(
            "uniform mat4 uMVPMatrix;",
            "attribute vec4 vPosition;",
            "void main() {gl_Position = vPosition;}"
        )


    val fragmentShaderCode =
        listOf(
            "precision mediump float;",
            "uniform vec4 vColor;",
            "void main() { gl_FragColor = vColor; }"
        )
}