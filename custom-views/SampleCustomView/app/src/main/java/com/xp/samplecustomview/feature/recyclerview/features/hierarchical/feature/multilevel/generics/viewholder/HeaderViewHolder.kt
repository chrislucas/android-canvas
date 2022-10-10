package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

class HeaderViewHolder(root: View): RecyclerView.ViewHolder(root) {


    val titleView: TextView by lazy { root.findViewById(R.id.tv_title_header_recycler_view) }

}