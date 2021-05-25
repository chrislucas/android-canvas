package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.customviews.view.fragment.CustomPopupViewFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment

class ItemFeatureCustomPopupView(@StringRes val description: Int)


class BindItemFeatureCustomPopupView(private val channel: ChannelCommunicationViewHolderFragment) :
        BindDataToViewHolder<ItemFeatureCustomPopupView> {
    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureCustomPopupView) {
        viewHolder.itemView.setOnClickListener {
            channel.call(CustomPopupViewFragment.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureCustomPopupView
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = viewHolder.itemView.context.getString(data.description)
    }

}