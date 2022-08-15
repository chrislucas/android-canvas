package com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.viewholders.LevelRecyclerViewViewHolder


typealias RecyclerViewAdapter = RecyclerView.Adapter<out RecyclerView.ViewHolder>

class LevelData<R : RecyclerViewAdapter>(
    val adapter: R,
    val layoutManager: RecyclerView.LayoutManager
)


class MultiLevelRecyclerViewAdapter<R : RecyclerViewAdapter>(private val items: List<LevelData<R>>) :
    RecyclerView.Adapter<LevelRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelRecyclerViewViewHolder {
        return LevelRecyclerViewViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(
        levelRecyclerViewViewHolder: LevelRecyclerViewViewHolder,
        position: Int
    ) {
        if (items.isNotEmpty()) {
            items[position].let { data ->
                with(levelRecyclerViewViewHolder.root as RecyclerView) {
                    adapter = data.adapter
                    layoutManager = data.layoutManager
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size
}

