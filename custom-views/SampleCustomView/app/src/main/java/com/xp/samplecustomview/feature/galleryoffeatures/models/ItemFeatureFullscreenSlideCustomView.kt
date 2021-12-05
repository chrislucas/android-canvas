package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.customviews.sample.samplesviewpager.view.fragment.FullScreenSliderCustomViewFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureCustomViewsViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.ListenerFeaturesViewHolder


class ItemFeatureFullscreenSlideCustomView(val description: String)

class BindItemFeatureFulscreenSlideCustomView(private val channel: ListenerFeaturesViewHolder) :
    BindDataToViewHolder<ItemFeatureFullscreenSlideCustomView> {
    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureFullscreenSlideCustomView) {
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

