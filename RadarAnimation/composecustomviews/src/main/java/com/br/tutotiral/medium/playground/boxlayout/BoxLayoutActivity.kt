package com.br.tutotiral.medium.playground.boxlayout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.br.tutotiral.medium.playground.boxlayout.ui.theme.RadarAnimationTheme

/**
 * https://foso.github.io/Jetpack-Compose-Playground/layout/box/
 */
class BoxLayoutActivity : ComponentActivity() {
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
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BoxSample()
        }
    }
}

@Composable
private fun SimpleBoxText() {
    /**
     * The children of the Box layout will be stacked over each other.
     * You can use the align modifier to specify where the composable should be drawn.
     */

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "1#",
            fontSize = 14.sp,
            lineHeight = 10.sp
        )
        Text(
            text = "2#",
            fontSize = 14.sp,
            lineHeight = 50.sp
        )
        Text(
            text = "3#",
            fontSize = 14.sp,
            lineHeight = 85.sp
        )
    }
}

@Composable
private fun BoxSample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)

    ) {
        // SimpleBoxText()

        Box(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Yellow)
        ) {
            Text(
                text = "Dev O Chris",
                Modifier.align(Alignment.Center)
            )
        }

        Text(
            text = "Text Middle of Screen",
            modifier = Modifier.align(Alignment.Center)
        )

        val ctx = LocalContext.current
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            onClick = {
                Toast.makeText(ctx, "", Toast.LENGTH_LONG).show()
            }) {
            Text(text = "+")
        }
    }
}


@Composable
private fun OwnBoxWithConstraints() {
    /**
     * TODO
     * https://foso.github.io/Jetpack-Compose-Playground/foundation/layout/boxwithconstraints/
     */
    BoxWithConstraints {
        val boxScope = this
        Column {
            Text(text = "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview19() {
    Render()
}