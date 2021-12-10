package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.feature.customviews.sample.viewpager.view.fragment.FullScreenSliderCustomViewFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureCustomViewsViewHolder


class ItemFeatureFullscreenSlideCustomView(val description: String)

class BindItemFeatureFullscreenSlideCustomView(private val channel: ListenerListFragmentsViewHolder) :
    BindDataToViewHolder<ItemFeatureFullscreenSlideCustomView> {
    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureFullscreenSlideCustomView
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(FullScreenSliderCustomViewFragment.newInstance())
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

