package com.br.tutotiral.medium.guidebook

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
import com.br.tutotiral.medium.guidebook.ui.theme.RadarAnimationTheme

/**
 * TODO
 * Compose Guidebook: Learn Android Jetpack Compose
 * https://github.com/myofficework000/Jetpack-Compose-All-in-one-Guide/tree/master
 *
 * Rows, Columns, and Boxes in Jetpack Compose: Compose Series #02
 * https://medium.com/@myofficework000/rows-columns-and-boxes-in-jetpack-compose-compose-series-02-309e4e1730e5
 */
class ComposeGuideBookActivity : ComponentActivity() {
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

        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview20() {
    Render()
}