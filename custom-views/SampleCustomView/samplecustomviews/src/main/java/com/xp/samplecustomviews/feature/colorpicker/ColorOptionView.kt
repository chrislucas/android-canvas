package com.xp.samplecustomviews.feature.colorpicker

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.xp.samplecustomviews.R
import com.xp.samplecustomviews.feature.clickable.action.SimpleClickView
import com.xp.samplecustomviews.helpers.log

class ColorOptionView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private lateinit var imageViewColor: ImageView
    private lateinit var viewValue: View

    private var behaviorCustomView: SimpleClickView? = null

    init {
        /**
         * Recuperando os atributos definidos no arquivo xml onde essa view sera/foi utilizada
         * */
        val styledAttributes =
            context?.obtainStyledAttributes(
                attrs, R.styleable.ColorOptionView, 0, 0
            )

        attrs?.log(javaClass.name)

        styledAttributes?.let { typedArray ->
            val titleText = typedArray.getString(R.styleable.ColorOptionView_titleText)
            val valueColor = typedArray.getColor(
                R.styleable.ColorOptionView_valueColor,
                ContextCompat.getColor(context, android.R.color.holo_blue_dark)
            )

            behaviorCustomView =
                createBehaviorInstance(typedArray.getString(R.styleable.ClickableView_classCreateBehavior))

            this.setOnClickListener { view ->
                behaviorCustomView?.let { behavior ->
                    behavior.onclick(view)
                }
            }


            with(this) {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL

                LayoutInflater.from(context).inflate(
                    R.layout.view_color_option, this, true
                )
                val textView = this.findViewById<TextView>(R.id.description)
                textView.text = titleText
            }
        }

        styledAttributes?.recycle()
    }

    private fun createBehaviorInstance(className: String?): SimpleClickView? {
        return className?.run cls@{
            this@cls::class.java.classLoader?.run {
                loadClass(this@cls).newInstance().run {
                    try {
                        this as SimpleClickView
                    } catch (e: ClassCastException) {
                        null
                    } catch (c: ClassNotFoundException) {
                        null
                    }
                }
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        this.log("onDraw")
    }

    /**
     * @see View.onAttachedToWindow
     * chamado quando a view eh anexada a WINDOW. Nesse ponto a view ja possui uma superficie
     * e comeca a ser desenhada. Ponto de atencao eh que esse metodo sera chamado antes do
     * onDraw, eh pode ser chamado antes do metodo onMeasure()
     * */
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        this.log("onAttachedToWindow")
    }

    /**
     * @see View.onDetachedFromWindow
     * */
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        this.log("onDetachedFromWindow")
    }

    /**
     * @see View.onMeasure
     * Metodo chamado para calcular a dimensao (w e h) dessa View e de suas views filhas.
     * A documentacao sugere que sobreescrevamos esse metodo para que a custom view seja desenhada com
     * maio precisao e eficiencia, caso necessario
     * */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        this.log("onDetachedFromWindow")
    }
}