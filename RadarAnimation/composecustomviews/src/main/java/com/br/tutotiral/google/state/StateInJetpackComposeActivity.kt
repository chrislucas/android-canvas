package com.br.tutotiral.google.state

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
import com.br.tutotiral.google.state.ui.theme.RadarAnimationTheme

/**
 * https://developer.android.com/develop/ui/compose/state
 * https://github.com/android/snippets/blob/b883fb9bca33ef91cbd8f6a5d69d4cfba80f8d4e/compose/snippets/src/main/java/com/example/compose/snippets/state/StateOverviewSnippets.kt#L51-L65
 */
class StateInJetpackComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Show()
        }
    }
}

@Composable
fun Show() {
    RadarAnimationTheme {

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Show()
}