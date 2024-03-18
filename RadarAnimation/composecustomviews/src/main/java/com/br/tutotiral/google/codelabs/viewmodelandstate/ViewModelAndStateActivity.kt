package com.br.tutotiral.google.codelabs.viewmodelandstate

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
import com.br.tutotiral.google.codelabs.viewmodelandstate.ui.theme.RadarAnimationTheme

/**
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state#0
 */
class ViewModelAndStateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Render("Chris")
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
fun RenderPreview() {
    Render("Chris")
}