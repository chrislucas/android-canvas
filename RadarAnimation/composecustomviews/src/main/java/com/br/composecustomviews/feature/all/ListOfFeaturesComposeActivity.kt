package com.br.composecustomviews.feature.all

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.br.composecustomviews.feature.all.ui.theme.RadarAnimationTheme

class ListOfFeaturesComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListOfFeatures()
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun PreviewListOfFeatures() {
    ListOfFeatures()
}


@Composable
private fun ListOfFeatures() {
    RadarAnimationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(innerPadding)
                    .size(100.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                repeat(10) {
                    Text(text = "Item $it", modifier = Modifier.padding(2.dp))
                }
            }
        }
    }
}