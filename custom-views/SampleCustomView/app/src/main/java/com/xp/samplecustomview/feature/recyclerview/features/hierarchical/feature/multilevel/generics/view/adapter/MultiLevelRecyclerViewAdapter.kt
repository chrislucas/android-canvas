package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.viewholder.ViewHolderForRecyclerView


typealias RVAdapter = RecyclerView.Adapter<out RecyclerView.ViewHolder>



class MultiLevelRecyclerViewAdapter<R : RVAdapter>(
    private val multiLevelStruct: MutableMap<Int, MultiLevelAdapterData<R>>
) : RecyclerView.Adapter<ViewHolderForRecyclerView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderForRecyclerView {
        return ViewHolderForRecyclerView.newInstance(parent)
    }

    private var lastLevel = 0

    override fun onBindViewHolder(
        levelRecyclerViewViewHolder: ViewHolderForRecyclerView,
        position: Int
    ) {
        multiLevelStruct[position]?.let { data ->
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

    fun updateLevel(level: Int, data: MultiLevelAdapterData<R>) {
        multiLevelStruct[level] = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = multiLevelStruct.size


    class MultiLevelAdapterData<R : RVAdapter>(
        val adapter: R,
        val layoutManager: RecyclerView.LayoutManager
    )
}

