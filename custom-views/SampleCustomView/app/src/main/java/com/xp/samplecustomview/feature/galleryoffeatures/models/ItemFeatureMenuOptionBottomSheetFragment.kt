package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.fragment.ListOptionsSampleBottomSheetFragment
import com.xp.samplecustomview.feature.customviews.sample.behaviorcustomview.view.fragment.AttachBehaviorOnCustomViewByXmlLayout
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment


class ItemFeatureMenuOptionBottomSheetFragment(val description: String)


class BindItemFeatureMenuOptionBottomSheetFragment(private val channel: ChannelCommunicationViewHolderFragment) :
    BindDataToViewHolder<ItemFeatureMenuOptionBottomSheetFragment> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureMenuOptionBottomSheetFragment
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.call(ListOptionsSampleBottomSheetFragment.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureMenuOptionBottomSheetFragment
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
    }
}