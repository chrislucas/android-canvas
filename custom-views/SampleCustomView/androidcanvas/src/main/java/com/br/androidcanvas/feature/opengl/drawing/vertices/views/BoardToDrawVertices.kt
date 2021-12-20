package com.br.androidcanvas.feature.opengl.drawing.vertices.views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.br.androidcanvas.R
import com.br.androidcanvas.ext.simplestDrawingVertices
import com.br.androidcanvas.feature.opengl.drawing.vertices.action.Draw
import com.br.classext.feature.builderbehavior.Behavior
import com.br.classext.feature.builderbehavior.fromClassNameToCreateBehavior

class BoardToDrawVerticesView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val paint = Paint()
    var vertexMode = Canvas.VertexMode.TRIANGLES

    private val vertices = mutableListOf<Float>()

    private var mBehavior: Behavior? = null

    init {
        val styledAttrs: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.BoardToDrawVerticesView)

        var hasAttr = styledAttrs.hasValue(R.styleable.BoardToDrawVerticesView_vertexMode) ?: false

        if (hasAttr) {
            val value = styledAttrs.getInt(R.styleable.BoardToDrawVerticesView_vertexMode, 0)
            vertexMode = when (value) {
                0 -> Canvas.VertexMode.TRIANGLES
                1 -> Canvas.VertexMode.TRIANGLE_STRIP
                else -> Canvas.VertexMode.TRIANGLE_FAN
            }
        }

        hasAttr = styledAttrs.hasValue(R.styleable.BoardToDrawVerticesView_drawBehavior)

        if (hasAttr) {
            mBehavior = styledAttrs.getString(R.styleable.BoardToDrawVerticesView_drawBehavior)
                ?.fromClassNameToCreateBehavior()
        }

        styledAttrs.recycle()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (width == 0 || height == 0)
            return
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)

        canvas?.simplestDrawingVertices(
            vertexMode,
            0,
            vertices.toFloatArray(),
            vColor,
            paint
        )

        mBehavior?.let { behavior ->
            if (behavior is Draw) {
                behavior.onDraw()
            }
        }
    }

    /**
     * Tex Shader
     * */
    fun drawBitmapShader() {
        val paint = Paint().apply {
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.triangle24px)
            this.shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        mBehavior?.let { behavior ->
            if (behavior is Draw) {
                behavior.onTouchEvent()
            }
        }

        if (vertices.size == 64) {
            Toast.makeText(
                context,
                context.getString(R.string.message_quantity_max_vertices), Toast.LENGTH_SHORT
            ).show()
            return false
        }

        event?.let {
            val pointerIndex = it.actionIndex

            return when (event.actionMasked) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> true
                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_POINTER_UP -> {
                    vertices.add(event.getX(pointerIndex))
                    vertices.add(event.getY(pointerIndex))
                    invalidate()
                    true
                }
                else -> {
                    false
                }
            }
        }

        return super.onTouchEvent(event)
    }

}