package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.viewholder.ViewHolderForRecyclerView


typealias RVAdapter = RecyclerView.Adapter<out RecyclerView.ViewHolder>

class MultiLevelRecyclerViewAdapter<R : RVAdapter>(
    private val multiLevelStruct: MutableMap<Int, MultiLevelAdapterStruct<R>>
) : RecyclerView.Adapter<ViewHolderForRecyclerView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderForRecyclerView {
        return ViewHolderForRecyclerView.newInstance(parent)
    }

    override fun onBindViewHolder(
        viewHolderRecyclerView: ViewHolderForRecyclerView,
        position: Int
    ) {
        multiLevelStruct[position]?.let { adapterStruct ->
            viewHolderRecyclerView.recyclerView.let {
                it.adapter = adapterStruct.adapter
                it.layoutManager = adapterStruct.layoutManager
            }
            viewHolderRecyclerView.tvTitle.text = adapterStruct.title
        }
    }

    fun updateLevel(level: Int, data: MultiLevelAdapterStruct<R>) {
        multiLevelStruct[level] = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = multiLevelStruct.size

    class MultiLevelAdapterStruct<R : RVAdapter>(
        val adapter: R,
        val layoutManager: RecyclerView.LayoutManager,
        val title: String
    )
}

