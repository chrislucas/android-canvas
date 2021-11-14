package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.customviews.view.fragment.FullScreenSliderCustomViewFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureCustomViewsViewHolder
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment


class ItemFeatureFullscreenSlideCustomView(val description: String)

class BindItemFeatureFulscreenSlideCustomView(private val channel: ChannelCommunicationViewHolderFragment) :
    BindDataToViewHolder<ItemFeatureFullscreenSlideCustomView> {
    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureFullscreenSlideCustomView) {
        viewHolder.itemView.setOnClickListener {
            channel.call(FullScreenSliderCustomViewFragment.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureFullscreenSlideCustomView
    ) {
        val vh = viewHolder as FeatureCustomViewsViewHolder
        vh.tvTitle.text = data.description
    }
}

