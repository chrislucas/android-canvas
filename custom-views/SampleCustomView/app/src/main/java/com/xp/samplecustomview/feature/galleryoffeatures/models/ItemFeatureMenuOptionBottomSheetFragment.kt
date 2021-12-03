package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.fragment.ShowListOptionsSimpleBottomSheetDialogFragment
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder


class ItemFeatureMenuOptionBottomSheetFragment(val description: String)


class BindItemFeatureMenuOptionBottomSheetFragment(private val channel: ListenerListFragmentsViewHolder) :
    BindDataToViewHolder<ItemFeatureMenuOptionBottomSheetFragment> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureMenuOptionBottomSheetFragment
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(ShowListOptionsSimpleBottomSheetDialogFragment.newInstance())
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