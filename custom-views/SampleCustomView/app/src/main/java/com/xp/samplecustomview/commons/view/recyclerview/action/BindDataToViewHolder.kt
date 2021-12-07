package com.xp.samplecustomview.commons.view.recyclerview.action

import androidx.recyclerview.widget.RecyclerView

interface BindDataToViewHolder<T> {
    fun onClick(viewHolder: RecyclerView.ViewHolder, data: T)
    fun fillViewHolderWithData(viewHolder: RecyclerView.ViewHolder, data: T)
}