package com.br.tutotiral.google.listsandgrids.recyclerview.adapter

import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.truncate

data class MyMessage(val content: String)


class Diff : DiffUtil.ItemCallback<MyMessage>() {
    override fun areItemsTheSame(oldItem: MyMessage, newItem: MyMessage): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: MyMessage, newItem: MyMessage): Boolean {
        return true

    }
}


/**
 * https://www.youtube.com/watch?v=1ANt65eoNhQ&t=1s
 */

class MessagesAdapter(
    asyncDifferConfig: AsyncDifferConfig<MyMessage>,
    private val onCLick: (MyMessage) -> Unit
) :
    ListAdapter<MyMessage, MessagesAdapter.MessageViewHolder>(asyncDifferConfig) {


    class MessageViewHolder(itemView: View, val onCLick: (MyMessage) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(parent, onCLick)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MessageLazyColumn(myMessages: List<MyMessage>) {
    LazyColumn(
        userScrollEnabled = true,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
        ,
        contentPadding = PaddingValues(top = 24.dp, bottom = 24.dp)
    ) {
        item {
            Text(
                text = "Lazy Column",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        items(myMessages) { message ->
            MessageColumn(myMessage = message)
        }
    }
}


@Composable
fun MessageIndexedLazyColumn(myMessages: List<MyMessage>) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp)
            .fillMaxWidth()
    ) {
        item {
            Text(text = "Lazy Column")
        }
        itemsIndexed(myMessages) { i, m ->
            MessageColumn(myMessage = MyMessage("IDX($i), $m"))
        }
    }
}


@Composable
fun MessageColumn(myMessage: MyMessage) {
    Column {
        Text(
            text = myMessage.content,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun MessageLazyRow(myMessages: List<MyMessage>) {
    LazyRow (
        userScrollEnabled = true,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
        ,
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(myMessages) { message ->
            MessageRow(myMessage = message)
        }
    }
}


@Composable
fun MessageRow(myMessage: MyMessage) {
    Row {
        Text(text = myMessage.content)
    }
}