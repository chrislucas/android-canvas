package com.br.tutotiral.google.workingwithimages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.br.composecustomviews.R
import com.br.tutotiral.google.workingwithimages.ui.theme.RadarAnimationTheme

/**
 * TODO
 * Working with images
 * https://developer.android.com/jetpack/compose/graphics/images
 *
 * Loading images
 * https://developer.android.com/jetpack/compose/graphics/images/loading
 */
class ImageInComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadarAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}

@Composable
private fun MainLayout() {
    RadarAnimationTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            BasicImage()
            CustomImage()
        }
    }
}

@Composable
private fun BasicImage() {
    /**
     * https://developer.android.com/jetpack/compose/graphics/images/loading
     */
    Box {
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "face"
        )
    }
}

@Composable
private fun CustomImage() {
    /**
     * https://developer.android.com/jetpack/compose/graphics/images/customize
     */
    Row(verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
        ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "face"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview18() {
    MainLayout()
}