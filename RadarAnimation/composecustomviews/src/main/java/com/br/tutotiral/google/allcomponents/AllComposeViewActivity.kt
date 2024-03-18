package com.br.tutotiral.google.allcomponents

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
import com.br.tutotiral.google.allcomponents.ui.theme.RadarAnimationTheme

/**
 * O objeto desse projeto é ter uma lista de todos os componentes visuais
 * que eu conseguir juntar.
 *
 * lista
 * https://developer.android.com/jetpack/compose/lists
 *
 * basics
 * https://developer.android.com/jetpack/compose/layouts/basics
 *
 * Buttons
 * https://developer.android.com/jetpack/compose/components/button
 *
 * Material components in Compose
 * https://developer.android.com/jetpack/compose/components
 *
 * Text
 * https://developer.android.com/jetpack/compose/text
 *
 * https://www.composables.com/
 * https://www.composables.com/
 *
 * Jetpack Compose
 * Android's modern toolkit for building native UI. Support is available for Material Design 3.
 * https://m3.material.io/develop/android/jetpack-compose
 */
class AllComposeViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadarAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting16("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting16(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview16() {
    RadarAnimationTheme {
        Greeting16("Android")
    }
}