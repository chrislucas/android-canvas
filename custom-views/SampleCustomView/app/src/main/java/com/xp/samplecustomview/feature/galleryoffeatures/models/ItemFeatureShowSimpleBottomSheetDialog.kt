package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.bottomsheet.dialogfragment.view.fragment.ShowSimpleBottomSheetDialog
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment

class ItemFeatureShowSimpleBottomSheetDialog(val description: String)


class BindItemFeatureShowSimpleBottomSheetDialog(private val channel: ChannelCommunicationViewHolderFragment) :
    BindDataToViewHolder<ItemFeatureShowSimpleBottomSheetDialog> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureShowSimpleBottomSheetDialog
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.call(ShowSimpleBottomSheetDialog.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureShowSimpleBottomSheetDialog
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
    }
}