package com.br.experience.features.codelabs.arch.basicroomwithflow.views.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.br.experience.features.codelabs.arch.basicroomwithflow.model.Word
import com.br.experience.features.codelabs.arch.basicroomwithflow.views.viewholder.FlowWorldViewHolder

class FlowWordListAdapter: ListAdapter<Word, FlowWorldViewHolder>(customItemCallback) {

    companion object {
        private val customItemCallback = object: DiffUtil.ItemCallback<Word>() {
            /**
             * https://kotlinlang.org/docs/equality.html
             * In Kotlin there are two types of equality:
             *
             * Structural equality (== - a check for equals())
             *
             * Referential equality (=== - two references point to the same object)
             */
            override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean =
                oldItem === newItem

            override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean =
                oldItem.content == newItem.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowWorldViewHolder =
        FlowWorldViewHolder(parent)

    override fun onBindViewHolder(holder: FlowWorldViewHolder, position: Int) =
        holder.bind(getItem(position))

}
