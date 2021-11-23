package com.xp.samplecustomview.commons.view.recyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.SimpleBindViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.models.HolderBinderViewHolder

class GenRecyclerViewWithListAdapter<T>(
    private val values: MutableList<HolderBinderViewHolder<T>>,
    private val simpleBindViewHolder: SimpleBindViewHolder,
    diffCallback: DiffUtil.ItemCallback<T>

) : ListAdapter<T, RecyclerView.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return simpleBindViewHolder.getViewHolder(viewType, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // DO NoTHING YET
    }
}