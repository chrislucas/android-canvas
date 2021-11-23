package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.ListenerFeaturesViewHolder

class ItemFeatureRecyclerViewListAdapterWithDiffCallback(val description: String)


typealias ChannelCommunication = ListenerFeaturesViewHolder


class BindItemFeatureRecyclerViewListAdapter(private val channel: ChannelCommunication) :
    BindDataToViewHolder<ItemFeatureRecyclerViewListAdapterWithDiffCallback> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureRecyclerViewListAdapterWithDiffCallback
    ) {

    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureRecyclerViewListAdapterWithDiffCallback
    ) {

    }
}