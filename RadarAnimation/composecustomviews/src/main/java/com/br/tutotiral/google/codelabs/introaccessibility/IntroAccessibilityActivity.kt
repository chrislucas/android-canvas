package com.br.tutotiral.google.codelabs.introaccessibility

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
import com.br.tutotiral.google.codelabs.introaccessibility.ui.theme.RadarAnimationTheme

/**
 * Accessibility in Jetpack Compose
 * https://developer.android.com/codelabs/jetpack-compose-accessibility#0\
 *
 * Testing for Accessibility
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-test-accessibility#0
 *
 */
class IntroAccessibilityActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadarAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting17("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting17(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview17() {
    RadarAnimationTheme {
        Greeting17("Android")
    }
}