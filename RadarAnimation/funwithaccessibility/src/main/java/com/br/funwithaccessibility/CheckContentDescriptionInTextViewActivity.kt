package com.br.funwithaccessibility

import android.os.Bundle
import android.view.accessibility.AccessibilityEvent
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CheckContentDescriptionInTextViewActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_check_content_description_in_text_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val text = findViewById<TextView>(R.id.tv_title_accessibility_event)

        text.setOnClickListener {
            val event = AccessibilityEvent.obtain()
            event.packageName = packageName
            event.eventType = AccessibilityEvent.TYPE_ANNOUNCEMENT
            event.text.add("Disparando um evento de acessibilidade")
            it.context.sendAccessibilityEvent(event)
        }
    }
}