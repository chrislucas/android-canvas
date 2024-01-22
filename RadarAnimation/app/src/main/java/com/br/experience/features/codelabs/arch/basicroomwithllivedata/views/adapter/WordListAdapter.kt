package com.br.experience.features.codelabs.arch.basicroomwithllivedata.views.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.model.Word
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.views.viewholder.WordViewHolder

/**
 * Links para estudar sobre diferenca de ListAdapter de RecyclerView.Adapter
 * https://medium.com/@ttdevelopment/recyclerview-adapter-vs-listadapter-a-beginners-comparison-cfabc02dd78f
 * https://medium.com/android-dev-br/como-criar-um-listadapter-usando-kotlin-1f2259840ebc
 */

class WordListAdapter: ListAdapter<Word, WordViewHolder>(WordsComparator) {


    companion object {
        private val WordsComparator = object : DiffUtil.ItemCallback<Word>() {
            override fun areItemsTheSame(oldItem: Word, newItem: Word) =
                oldItem === newItem

            override fun areContentsTheSame(oldItem: Word, newItem: Word) =
                oldItem.value == newItem.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(getItem(position).value)
    }
}