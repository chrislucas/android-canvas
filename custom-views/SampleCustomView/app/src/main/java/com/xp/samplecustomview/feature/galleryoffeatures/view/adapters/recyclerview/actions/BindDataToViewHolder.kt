package com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.actions

import androidx.recyclerview.widget.RecyclerView

interface BindDataToViewHolder<T> {
    fun onClick(viewHolder: RecyclerView.ViewHolder, data: T)
    fun fillViewHolderWithData(viewHolder: RecyclerView.ViewHolder, data: T)
}