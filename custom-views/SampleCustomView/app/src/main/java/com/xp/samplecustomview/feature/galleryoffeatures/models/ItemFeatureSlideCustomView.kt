package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.customviews.view.fragment.SlideCustomViewFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureCustomViews
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment


class ItemFeatureSlideCustomView(val description: String)

class BindItemFeatureSlideCustomView(private val channel: ChannelCommunicationViewHolderFragment) :
    BindDataToViewHolder<ItemFeatureSlideCustomView> {
    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureSlideCustomView) {
        viewHolder.itemView.setOnClickListener {
            channel.call(SlideCustomViewFragment.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureSlideCustomView
    ) {
        val vh = viewHolder as FeatureCustomViews
        vh.tvTitle.text = data.description
    }
}

