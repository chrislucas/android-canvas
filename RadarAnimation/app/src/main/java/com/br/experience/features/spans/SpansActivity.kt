package com.br.experience.features.spans

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.br.experience.radaranimation.R


/**
 * https://developer.android.com/develop/ui/views/text-and-emoji/spans?authuser=1
 *
 * Definicao de spans:
 *  - Um recurso que permite estilizar textos desde um caracter até paragrafos.
 *  - Adicionando um Span a um objeto de texto, podemos muda-lo de varias maneira
 *      - Cor, fazer o texto ser "clicável", modificar o tamanho do texto e desenhar
 *      um texto de forma personalizada
 *      - Span podem mudar propriedades de TextPaint, desenhar no canvas e mudar o layout
 *      do texto
 *
 */
class SpansActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spans)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}