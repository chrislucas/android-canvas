package com.br.experience.features.tutorials.medium.unittestcoroutines

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
import com.br.experience.features.tutorials.medium.unittestcoroutines.ui.theme.RadarAnimationTheme

/**
 * Unit Testing with Kotlin Coroutines: The Android Way
 * https://medium.com/swlh/unit-testing-with-kotlin-coroutines-the-android-way-19289838d257
 */
class UnitTestCoroutinesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Render(name = "Test")
        }
    }
}

@Composable
fun Render(name: String, modifier: Modifier = Modifier) {
    RadarAnimationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Render(name = "Test")
}