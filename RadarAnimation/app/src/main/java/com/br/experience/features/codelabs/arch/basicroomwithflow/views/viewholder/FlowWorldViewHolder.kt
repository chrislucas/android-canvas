package com.br.experience.features.codelabs.arch.basicroomwithflow.views.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.experience.features.codelabs.arch.basicroomwithflow.model.Word
import com.br.experience.radaranimation.databinding.LayoutWordViewHolderBinding

class FlowWorldViewHolder(root: ViewGroup): RecyclerView.ViewHolder(
    LayoutWordViewHolderBinding.inflate(
        LayoutInflater.from(root.context), root, false
    ).root
) {

    private val layoutBinder = LayoutWordViewHolderBinding.bind(itemView)

    fun bind(word: Word) {
        layoutBinder.tvWord.text = word.content
    }
}