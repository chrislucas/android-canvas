package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.viewholder.ViewHolderForRecyclerView


typealias RVAdapter = RecyclerView.Adapter<out RecyclerView.ViewHolder>

class LevelData<R : RVAdapter>(val adapter: R, val layoutManager: RecyclerView.LayoutManager)

class MultiLevelRecyclerViewAdapter<R : RVAdapter>(
    private val it: MutableMap<Int, MutableList<LevelData<R>>>
) : RecyclerView.Adapter<ViewHolderForRecyclerView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderForRecyclerView {
        return ViewHolderForRecyclerView.newInstance(parent)
    }

    override fun onBindViewHolder(
        levelRecyclerViewViewHolder: ViewHolderForRecyclerView,
        position: Int
    ) {

        for ((_, item) in it) {
            if (item.isNotEmpty()) {
                item[position].let { data ->
                    with(levelRecyclerViewViewHolder.root as RecyclerView) {
                        adapter = data.adapter
                        layoutManager = data.layoutManager
                    }
                }
            }
        }
    }

    fun updateLevel(level: Int, items: List<LevelData<R>>) {
        if (it[level] != null) {
            val oldSize = it.size
            val newSize = items.size
            it[level]?.clear()
            it[level]?.addAll(items)
            notifyItemRangeRemoved(0, oldSize)
            notifyItemRangeInserted(0, newSize)
        } else {
            it[level] = mutableListOf()
            it[level]?.addAll(items)
        }
    }

    override fun getItemCount(): Int = it.size
}

