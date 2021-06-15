package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment


open class ItemFeatureDefault(val description: String)


open class BindItemFeatureDefault(
    private val channel: ChannelCommunicationViewHolderFragment,
    val baseBehaviorFragment: BaseBehaviorFragment
) :
    BindDataToViewHolder<ItemFeatureDefault> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureDefault) {
        viewHolder.itemView.setOnClickListener {
            channel.call(baseBehaviorFragment)
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureDefault
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
    }

}