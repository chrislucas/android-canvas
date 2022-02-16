package com.xp.samplecustomview.feature.recyclerview.samples.composite.view.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

class HorizontalRecyclerViewViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
    val rootRecyclerView : RecyclerView = root.findViewById(R.id.rc_multilevel_department)
}