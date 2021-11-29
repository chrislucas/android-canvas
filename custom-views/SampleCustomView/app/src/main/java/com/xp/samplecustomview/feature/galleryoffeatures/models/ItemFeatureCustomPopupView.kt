package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.customviews.sample.popupview.view.fragment.CustomPopupViewFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.ListenerFeaturesViewHolder

class ItemFeatureCustomPopupView(val description: String)


class BindItemFeatureCustomPopupView(private val channel: ListenerFeaturesViewHolder) :
    BindDataToViewHolder<ItemFeatureCustomPopupView> {
    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureCustomPopupView) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(CustomPopupViewFragment.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureCustomPopupView
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
    }

}