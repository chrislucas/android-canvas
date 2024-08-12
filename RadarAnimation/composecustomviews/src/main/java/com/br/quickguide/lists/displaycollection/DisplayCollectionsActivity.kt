package com.br.quickguide.lists.displaycollection

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
import com.br.quickguide.lists.displaycollection.ui.theme.RadarAnimationTheme


/**
 * https://developer.android.com/quick-guides?hl=en&text=list
 * https://developer.android.com/quick-guides/collections/display-a-list-or-grid?hl=en
 */
class DisplayCollectionsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /**
         * @see setContent
         */
        setContent {
            ShowCreateVerticalScrollingList()
        }
    }
}

@Composable
fun SimpleText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
private fun ShowSimpleText() {
    RadarAnimationTheme {
        /**
         * @see Scaffold
         */
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SimpleText(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ShowCreateVerticalScrollingList()
}

@Composable
private fun ShowCreateVerticalScrollingList() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        CreateVerticalScrollingList(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun CreateVerticalScrollingList(modifier: Modifier) {
    /**
     * https://developer.android.com/quick-guides/content/finite-scrolling-list?hl=en\
     * @see rememberScrollState
     */

    Column(
        modifier = modifier
            .background(Color.LightGray)
            .size(100.dp)
            .verticalScroll(rememberScrollState())
    ) {
        repeat(10) {
            Text(text = "Item $it", modifier = Modifier.padding(2.dp))
        }
    }
}
