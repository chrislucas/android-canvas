package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.bottomsheet.dialogfragment.view.fragment.ShowSimpleBottomSheetDialog
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.ListenerFeaturesViewHolder

class ItemFeatureShowSimpleBottomSheetDialog(val description: String)


class BindItemFeatureShowSimpleBottomSheetDialog(private val channel: ListenerFeaturesViewHolder) :
    BindDataToViewHolder<ItemFeatureShowSimpleBottomSheetDialog> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureShowSimpleBottomSheetDialog
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(ShowSimpleBottomSheetDialog.newInstance())
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