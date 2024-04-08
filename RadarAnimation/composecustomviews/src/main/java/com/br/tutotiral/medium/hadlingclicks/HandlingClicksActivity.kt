package com.br.tutotiral.medium.hadlingclicks

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
import com.br.tutotiral.medium.hadlingclicks.ui.theme.RadarAnimationTheme

/**
 * TODO
 * https://proandroiddev.com/handling-clicks-in-jetpack-compose-3800379845c4
 */
class HandlingClicksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Render()
        }
    }
}

@Composable
private fun Render() {
    RadarAnimationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview21() {
    Render()
}