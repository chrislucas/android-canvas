package com.br.experience.features.codelabs.arch.basicroomwithllivedata.views.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.experience.radaranimation.databinding.LayoutWordViewHolderBinding

class WordViewHolder(root: ViewGroup) : RecyclerView.ViewHolder(
    LayoutWordViewHolderBinding.inflate(
        LayoutInflater.from(root.context),
        root,
        false
    ).root
) {

    private val layoutBinder = LayoutWordViewHolderBinding.bind(itemView)

    fun bind(content: String) {
        layoutBinder.tvWord.text = content
    }
}