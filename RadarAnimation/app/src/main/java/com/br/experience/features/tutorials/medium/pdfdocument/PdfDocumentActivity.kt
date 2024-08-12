package com.br.experience.features.tutorials.medium.pdfdocument

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.br.experience.radaranimation.R


/**
 * TODO
 * https://developer.android.com/reference/android/graphics/pdf/PdfDocument
 * https://medium.com/@meet30997/creating-dynamic-pdf-documents-with-android-step-by-step-tutorial-for-dynamic-pdfs-5e15fdd92bb7
 */

class PdfDocumentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pdf_document)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}