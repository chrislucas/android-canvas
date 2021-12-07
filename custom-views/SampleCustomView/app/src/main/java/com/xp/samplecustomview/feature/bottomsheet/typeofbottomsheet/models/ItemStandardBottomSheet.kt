package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.view.fragment.StandardBottomSheetFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault

class ItemStandardBottomSheet(private val listener: ListenerListFragmentsViewHolder) :
    CompositeListItem {
    override fun getDescription(): String = "StandardBottomSheet"

    override fun apply() {
        listener.onInteractWithView(StandardBottomSheetFragment.newInstance())
    }
}


class BindItemStandardBottomSheet : BindDataToViewHolder<ItemStandardBottomSheet> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemStandardBottomSheet) {
        viewHolder.itemView.setOnClickListener {
            data.apply()
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemStandardBottomSheet
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.getDescription()
    }

}