package com.br.tutotiral.medium.flexboxlayoutbehavior

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
import com.br.tutotiral.medium.flexboxlayoutbehavior.ui.theme.RadarAnimationTheme

/**
 * TODO
 * https://engineering.zalando.com/posts/2021/03/flexbox-layout-behavior-in-jetpack-compose.html
 */
class FlexBoxLayoutBehaviorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadarAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting19("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting19(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview24() {
    RadarAnimationTheme {
        Greeting19("Android")
    }
}