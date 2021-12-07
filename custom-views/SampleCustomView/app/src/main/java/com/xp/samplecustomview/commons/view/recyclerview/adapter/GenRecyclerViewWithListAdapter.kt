package com.xp.samplecustomview.commons.view.recyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.SimpleBindViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.model.VIEW_HOLDER_UNDEFINED
import com.xp.samplecustomview.feature.galleryoffeatures.models.CompositeRecyclerViewItem

class GenRecyclerViewWithListAdapter<T>(
    private val values: MutableList<CompositeRecyclerViewItem<T>>,
    private val simpleBindViewHolder: SimpleBindViewHolder,
    diffCallback: DiffUtil.ItemCallback<T>

) : ListAdapter<T, RecyclerView.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return simpleBindViewHolder.getViewHolder(viewType, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (values.isNotEmpty()) {
            values[position].run {
                binder.fillViewHolderWithData(holder, this.item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int = if (values.isNotEmpty()) {
        values[position].getItemViewType()
    } else {
        VIEW_HOLDER_UNDEFINED
    }

    override fun getItemCount(): Int = if (values.isEmpty()) {
        1
    } else {
        values.size
    }
}