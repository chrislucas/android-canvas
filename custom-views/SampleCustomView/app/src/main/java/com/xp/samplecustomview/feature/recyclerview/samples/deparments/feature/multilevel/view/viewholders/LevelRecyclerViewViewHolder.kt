package com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

class LevelRecyclerViewViewHolder private constructor(val root: View) :
    RecyclerView.ViewHolder(root) {
    companion object {
        @JvmStatic
        fun newInstance(parent: ViewGroup): LevelRecyclerViewViewHolder {
            val viewRoot = LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.layout_item_recycler_view_view_holder,
                    parent, false
                )
            return LevelRecyclerViewViewHolder(viewRoot)
        }
    }
}

