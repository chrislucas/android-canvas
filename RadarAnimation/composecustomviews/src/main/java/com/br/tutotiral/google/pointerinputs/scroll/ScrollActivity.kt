package com.br.tutotiral.google.pointerinputs.scroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.br.tutotiral.google.pointerinputs.scroll.ui.theme.RadarAnimationTheme

/**
 * https://developer.android.com/develop/ui/compose/touch-input/pointer-input/scroll
 */
class ScrollActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Show()
        }
    }
}

@Composable
fun Show() {
    RadarAnimationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Modifier.padding(innerPadding)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Show()
}