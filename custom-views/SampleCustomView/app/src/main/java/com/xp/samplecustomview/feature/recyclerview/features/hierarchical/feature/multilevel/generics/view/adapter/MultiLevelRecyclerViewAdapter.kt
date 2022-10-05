package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.viewholder.ViewHolderForRecyclerView


typealias RVAdapter = RecyclerView.Adapter<out RecyclerView.ViewHolder>

class AdapterData<R : RVAdapter>(val adapter: R, val layoutManager: RecyclerView.LayoutManager)

class MultiLevelRecyclerViewAdapter<R : RVAdapter>(
    private val map: MutableMap<Int, AdapterData<R>>
) : RecyclerView.Adapter<ViewHolderForRecyclerView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderForRecyclerView {
        return ViewHolderForRecyclerView.newInstance(parent)
    }

    private var lastLevel = 0

    override fun onBindViewHolder(
        levelRecyclerViewViewHolder: ViewHolderForRecyclerView,
        position: Int
    ) {
        map[position]?.let { data ->
            when (levelRecyclerViewViewHolder.root) {
                is RecyclerView -> {
                    levelRecyclerViewViewHolder.root.let {
                        it.adapter = data.adapter
                        it.layoutManager = data.layoutManager
                    }
                }
            }
        }
    }

    fun updateLevel(level: Int, data:AdapterData<R>) {
        map[level] = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = map.size
}

