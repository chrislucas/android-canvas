package com.br.experience.features.book.android2dgraphics.chp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.features.drawingbasicshapes.views.CanvasView
import com.br.experience.radaranimation.databinding.ActivityDrawingPrimitivesBinding

class DrawingPrimitivesActivity : AppCompatActivity() {

    private val bind: ActivityDrawingPrimitivesBinding by lazy {
        ActivityDrawingPrimitivesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        bindViews()
    }

    private fun bindViews() {

        with(bind) {
            btDrawingCircle.setOnClickListener {
                with(canvas) {
                    setDrawGeometricForm(
                        providerDefaultCircle()
                    )
                    invalidate()
                }
            }


            btDrawingSquare.setOnClickListener {
                with(canvas) {
                    setDrawGeometricForm(
                        providerDefaultSquare()
                    )
                    invalidate()
                }
            }

            btDrawingTriangle.setOnClickListener {
                canvas.drawTriangle()
            }
        }
    }
}