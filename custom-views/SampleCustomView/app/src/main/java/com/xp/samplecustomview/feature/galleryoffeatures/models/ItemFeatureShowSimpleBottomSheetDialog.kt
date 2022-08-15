package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.feature.bottomsheet.dialogfragment.view.fragment.ShowSimpleMenuBottomSheetDialogFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault

class ItemFeatureShowSimpleBottomSheetDialog(val description: String)

class BindItemFeatureShowSimpleBottomSheetDialog(private val channel: ListenerListFragments) :
    BindDataToViewHolder<ItemFeatureShowSimpleBottomSheetDialog> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureShowSimpleBottomSheetDialog
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(ShowSimpleMenuBottomSheetDialogFragment.newInstance())
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