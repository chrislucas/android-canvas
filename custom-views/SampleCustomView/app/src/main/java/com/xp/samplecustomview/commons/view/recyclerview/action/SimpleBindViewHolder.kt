package com.xp.samplecustomview.commons.view.recyclerview.action

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface SimpleBindViewHolder {
    fun getViewHolder(viewType: Int, viewRoot: ViewGroup): RecyclerView.ViewHolder
}