package com.br.experience.features.codelabs.viewmodelunittest.scramblewordgamecopy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.br.experience.features.codelabs.viewmodelunittest.scramblewordgamecopy.ui.GameScreen
import com.br.experience.features.codelabs.viewmodelunittest.scramblewordgamecopy.ui.theme.RadarAnimationTheme

/**
 * Write unit tests for ViewModel
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-test-viewmodel#0
 *
 * ViewModel and State in Compose
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state#1
 *
 * Write automated tests
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-write-automated-tests#0
 */
class ScrambleGameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            RenderLayout()
        }
    }
}


@Composable
private fun RenderLayout() {
    RadarAnimationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GameScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLayout() {
    RenderLayout()
}


