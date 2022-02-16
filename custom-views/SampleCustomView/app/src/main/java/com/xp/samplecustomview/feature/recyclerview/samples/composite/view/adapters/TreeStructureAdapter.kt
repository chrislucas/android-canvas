package com.xp.samplecustomview.feature.recyclerview.samples.composite.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.view.recyclerview.action.ProviderViewTypeForViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.model.ViewType
import com.xp.samplecustomview.feature.recyclerview.samples.composite.view.holder.HorizontalRecyclerViewViewHolder

class TreeStructureAdapter(private val data: List<RecyclerView>) :
    RecyclerView.Adapter<HorizontalRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HorizontalRecyclerViewViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(
                R.layout.layout_item_feature_horizontal_recycler_view,
                parent, false
            ).run {
                HorizontalRecyclerViewViewHolder(this)
            }
    }

    override fun onBindViewHolder(
        holderHorizontal: HorizontalRecyclerViewViewHolder,
        position: Int
    ) {
        // DO NOTHING
    }

    override fun getItemCount(): Int = data.size
}

class AdapterForRecyclerViewInTreeStructure<T>(
    private val data: List<Item<T>>,
    private val bindViewHolder: BindViewHolder
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        bindViewHolder.getViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (data.isNotEmpty()) {
            data[position].let {
                it.binder.fillViewHolderWithData(holder, it.data)
                it.binder.onClick(holder, it.data)
            }
        }
    }

    override fun getItemCount(): Int = data.size
}

interface BindViewHolder {
    fun getViewHolder(viewRoot: ViewGroup, viewType: Int): RecyclerView.ViewHolder
}

class Item<T>(
    @ViewType val viewType: Int,
    val data: T,
    val binder: BindDataViewHolder<T>
) : ProviderViewTypeForViewHolder {
    override fun getItemViewType(): Int = viewType
}


interface BindDataViewHolder<T> {
    fun onClick(viewHolder: RecyclerView.ViewHolder, data: T)
    fun fillViewHolderWithData(viewHolder: RecyclerView.ViewHolder, data: T)
}