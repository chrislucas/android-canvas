package com.br.composecustomviews.feature.tutorialgoogle

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
import com.br.composecustomviews.feature.tutorialgoogle.ui.theme.RadarAnimationTheme

/**
 * https://developer.android.com/jetpack/compose/tutorial?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-1%3Fhl%3Dpt-br%23article-https%3A%2F%2Fdeveloper.android.com%2Fjetpack%2Fcompose%2Ftutorial
 *
 * Nocoes basicas
 * https://developer.android.com/courses/pathways/jetpack-compose-for-android-developers-1?hl=pt-br
 *
 * Quick Start
 * https://developer.android.com/jetpack/compose/setup
 */
class JetpackComposeTutorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadarAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    RadarAnimationTheme {
        Greeting2("Android")
    }
}