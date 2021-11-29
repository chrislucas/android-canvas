package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.fragment.ListOptionsSampleBottomSheetFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.ListenerFeaturesViewHolder


class ItemFeatureMenuOptionBottomSheetFragment(val description: String)


class BindItemFeatureMenuOptionBottomSheetFragment(private val channel: ListenerFeaturesViewHolder) :
    BindDataToViewHolder<ItemFeatureMenuOptionBottomSheetFragment> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureMenuOptionBottomSheetFragment
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(ListOptionsSampleBottomSheetFragment.newInstance())
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