package com.br.composecustomviews.feature.canvas

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
import com.br.composecustomviews.feature.canvas.ui.theme.RadarAnimationTheme


/*
    https://developer.android.com/develop/ui/compose/graphics/draw/overview
    https://developer.android.com/develop/ui/compose/graphics
    https://foso.github.io/Jetpack-Compose-Playground/foundation/canvas/

    Medium
    https://proandroiddev.com/exploring-canvas-in-jetpack-compose-crafting-graphics-animations-and-game-experiences-b0aa31160bff
    https://medium.com/falabellatechnology/jetpack-compose-canvas-8aee73eab393
    https://medium.com/ioasys-voices/jetpack-compose-come%C3%A7ando-com-canvas-cda3b8ff2e93

    KtAcademy
    https://blog.kotlin-academy.com/canvas-in-jetpack-compose-c6e7b651fd9b

    StackOverflow
    https://stackoverflow.com/questions/77910822/implement-draw-undo-redo-erase-and-save-in-canvas-jetpack-compose-android
    https://stackoverflow.com/questions/77299943/draw-image-with-fixed-height-and-width-jetpack-compose-canvas-using-drawimage

    Youtube
    https://www.youtube.com/watch?v=78NF5mHmZyY

 */
class AllCanvasTutorialsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RadarAnimationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting37(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting37(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview42() {
    RadarAnimationTheme {
        Greeting37("Android")
    }
}