package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.customviews.view.fragment.ScreenSliderCustomViewFragment
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureCustomViewsViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder

class ItemFeatureSlideCustomView(val description: String)

class BindItemFeatureSlideCustomView(private val channel: ListenerListFragmentsViewHolder) :
    BindDataToViewHolder<ItemFeatureSlideCustomView> {
    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureSlideCustomView) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(ScreenSliderCustomViewFragment.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureSlideCustomView
    ) {
        val vh = viewHolder as FeatureCustomViewsViewHolder
        vh.tvTitle.text = data.description
    }
}