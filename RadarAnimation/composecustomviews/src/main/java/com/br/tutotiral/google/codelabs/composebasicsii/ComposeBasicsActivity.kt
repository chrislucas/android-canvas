package com.br.tutotiral.google.codelabs.composebasicsii

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.br.composecustomviews.R
import com.br.tutotiral.google.codelabs.composebasicsii.ui.theme.RadarAnimationTheme

/**
 * https://developer.android.com/codelabs/jetpack-compose-basics#0
 */
class ComposeBasicsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicConcepts()
        }
    }
}

@Composable
private fun BasicConcepts() {
    RadarAnimationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ArtisticCartRowDefault()
        }
    }
}

@Composable
private fun ArtisticCartRowDefault() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Box {
            /*
            Image(
                painter = painterResource(id = R.drawable.face_icon_background),
                contentScale = ContentScale.Fit,
                contentDescription = "",
                modifier = Modifier.size(150.dp)
                    .border(BorderStroke(1.dp, Color.Black))
                    .background(Color.Blue)
            )

            Image( BitmapFactory.decodeResource(
                LocalContext.current.resources,
                R.drawable.face_icon_background
            ).asImageBitmap(), contentDescription = "")
             */

            Icon(Icons.Filled.Check, contentDescription = "")
        }

        Column {
            Text(text = "Name")
            Text(text = "Other Name")
        }
    }
}

@Preview(
    showBackground = false,
    showSystemUi = true,
    name = "Previews"
)
@Composable
fun Previews() {
    BasicConcepts()
}