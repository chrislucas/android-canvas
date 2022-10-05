package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.feature.recyclerview.features.checklistadapter.view.fragments.SampleRecyclerViewListAdapter

class ItemFeatureRecyclerViewListAdapterWithDiffCallback(val description: String)

typealias ChannelCommunication = ListenerListFragmentsViewHolder

class BindItemFeatureRecyclerViewListAdapter(private val channel: ChannelCommunication) :
    BindDataToViewHolder<ItemFeatureRecyclerViewListAdapterWithDiffCallback> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureRecyclerViewListAdapterWithDiffCallback
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(SampleRecyclerViewListAdapter.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureRecyclerViewListAdapterWithDiffCallback
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
        mView.viewIcon.setImageDrawable(
            AppCompatResources.getDrawable(
                viewHolder.itemView.context,
                R.mipmap.ic_launcher_round
            )
        )
    }
}