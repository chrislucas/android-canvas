package com.br.tutotiral.google.listsandgrids

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.br.tutotiral.google.listsandgrids.recyclerview.adapter.MessageIndexedLazyColumn
import com.br.tutotiral.google.listsandgrids.recyclerview.adapter.MessageLazyColumn
import com.br.tutotiral.google.listsandgrids.recyclerview.adapter.MessageLazyRow
import com.br.tutotiral.google.listsandgrids.recyclerview.adapter.MyMessage
import com.br.tutotiral.google.listsandgrids.ui.theme.RadarAnimationTheme


/**
 * Lists and grids
 * https://developer.android.com/develop/ui/compose/lists
 * https://www.youtube.com/watch?v=1ANt65eoNhQ&t=1s
 *
 * TODO
 * https://stackoverflow.com/questions/60765370/what-is-the-jetpack-compose-equivalent-of-recyclerview-or-listview
 * https://stackoverflow.com/questions/65707293/what-is-the-alternative-to-linearlayout-in-android-jetpack-compose
 */
class ListsAndGridsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShowMessageLazyColumn()
        }
    }
}


private object ListSnippetColumn {

    @Composable
    fun MessageList(messages: List<Message>) {
        RadarAnimationTheme {
            Column {
                messages.forEach { MessageRow(message = it) }
            }
        }
    }
}


@Composable
fun ShowMessageLazyColumn() {
    RadarAnimationTheme {
        Column (
            verticalArrangement = Arrangement.Center
        ){
            MessageLazyColumn(
                (1..10).map {
                    MyMessage("#$it - content")
                }
            )

            MessageLazyRow(
                (1..20).map {
                    MyMessage("#$it")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ShowMessageLazyColumn()
}

private class Message(val id: Long)
private class Item

private data class Contact(val name: String)

private val contacts = listOf<Contact>()

private class Photo

private val photos = listOf<Photo>()

@Composable
private fun MessageRow(message: Message) = Unit

@Composable
private fun MessagePlaceholder() = Unit

@Composable
private fun ItemRow(item: Item) = Unit

@Composable
private fun Header() = Unit

@Composable
private fun CharacterHeader(initial: Char) = Unit

@Composable
private fun ContactListItem(contact: Contact) = Unit

@Composable
private fun PhotoItem(photo: Photo) = Unit

@Composable
private fun ScrollToTopButton(onClick: () -> Unit = {}) = Unit


private object MyAnalyticsService {
    fun sendScrolledPastFirstItemEvent() = Unit
}

private class ContentTypeElement(val type: Long)

private val elements = listOf<ContentTypeElement>()