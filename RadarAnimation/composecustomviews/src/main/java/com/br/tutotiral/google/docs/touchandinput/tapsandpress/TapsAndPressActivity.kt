package com.br.tutotiral.google.docs.touchandinput.tapsandpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.br.tutotiral.google.docs.touchandinput.tapsandpress.ui.theme.RadarAnimationTheme

/**
 * TODO
 * https://developer.android.com/jetpack/compose/touch-input/pointer-input/tap-and-press
 */
class TapsAndPressActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Render()
        }
    }
}

@Composable
fun Render() {
    RadarAnimationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            onClick = {}
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview22() {
    Render()
}