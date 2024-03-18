package com.br.tutotiral.google.allcomponents.feature.basiclists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.br.tutotiral.google.allcomponents.feature.basiclists.ui.theme.RadarAnimationTheme

/**
 * https://developer.android.com/jetpack/compose/lists
 */
class SampleOfListsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout()
        }
    }
}

@Composable
private fun MainLayout() {
    RadarAnimationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Lists()
        }
    }
}

private data class Message(val content: String)

@Composable
private fun MessageInRow() {
    Row {

    }
}


@Composable
private fun Lists() {
    LazyColumn {
        item {
            LazyColumnFakeItems()
        }

        item {
            LazyRowFakeItems()
        }
    }
}

@Composable
private fun LazyColumnFakeItems() =
    LazyColumn {
        item {
            Text(text = "1# item")
        }

        item {
            Text(text = "2# item")
        }

        items(5) {
            Text(text = "$it# item")
        }
    }



@Composable
private fun LazyRowFakeItems() =
    LazyRow {
        items(10) {
            Text(text = "$it# item")
        }
    }

@Preview(showBackground = true)
@Composable
fun ShowPreviously() {
    MainLayout()
}