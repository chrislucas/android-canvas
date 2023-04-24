package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R


/*
    View Holder para um recyclerview que exibe recycler-views como seus items
 */
class ViewHolderForRecyclerView private constructor(val root: View) :
    RecyclerView.ViewHolder(root) {

    companion object {
        @JvmStatic
        fun newInstance(parent: ViewGroup): ViewHolderForRecyclerView {
            val viewRoot = LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.layout_item_recycler_view_view_holder,
                    parent, false
                )
            return ViewHolderForRecyclerView(viewRoot)
        }
    }
}

