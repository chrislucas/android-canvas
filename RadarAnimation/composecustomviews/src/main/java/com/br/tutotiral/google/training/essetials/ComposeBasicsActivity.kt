package com.br.tutotiral.google.training.essetials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.view.menu.ShowableListMenu
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.br.tutotiral.google.training.essetials.ui.theme.RadarAnimationTheme


/**
 * https://developer.android.com/codelabs/jetpack-compose-basics?authuser=1#0
 *
 * advantages of recomposition jetpack compose
 *
 * recomposition jetpack compose
 * https://developer.android.com/develop/ui/compose/lifecycle
 * https://developer.android.com/develop/ui/compose/mental-model
 */
class ComposeBasicsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuildLayout()
        }
    }
}

@Composable
fun Content(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    BuildLayout()
}


@Composable
private fun BuildLayout() {
    RadarAnimationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Content(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
