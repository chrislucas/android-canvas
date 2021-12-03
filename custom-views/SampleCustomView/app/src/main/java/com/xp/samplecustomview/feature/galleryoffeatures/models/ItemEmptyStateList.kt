package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder

class ItemEmptyStateList

class BindEmptyStateListViewHolder : BindDataToViewHolder<ItemEmptyStateList> {
    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemEmptyStateList) {
        // DO NOTHING YET
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemEmptyStateList
    ) {
        // DO NOTHING YET
    }
}