package com.xp.samplecustomview.commons.view.recyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.SimpleBindViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.model.VIEW_HOLDER_UNDEFINED
import com.xp.samplecustomview.feature.galleryoffeatures.models.CompositeRecyclerViewItem

class GenRecyclerView<T>(
    private val values: MutableList<CompositeRecyclerViewItem<T>>,
    private val simpleBindViewHolder: SimpleBindViewHolder,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return simpleBindViewHolder.getViewHolder(viewType, parent)
    }

    override fun onViewAttachedToWindow(viewHolder: RecyclerView.ViewHolder) {
        if (viewHolder.absoluteAdapterPosition >= 0) {
            values[viewHolder.absoluteAdapterPosition].run {
                val item = this.item
                binder.onClick(viewHolder, item)
            }
        }
        super.onViewAttachedToWindow(viewHolder)
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

    override fun getItemCount(): Int = if (values.isEmpty()) 1 else values.size
}