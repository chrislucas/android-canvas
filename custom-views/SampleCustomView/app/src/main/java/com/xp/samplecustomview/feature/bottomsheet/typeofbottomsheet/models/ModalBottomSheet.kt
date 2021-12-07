package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.view.fragment.ModalBottomSheetExampleFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault

class ItemModalBottomSheet(private val listener: ListenerListFragmentsViewHolder) :
    CompositeListItem {
    override fun apply() {
        listener.onInteractWithView(ModalBottomSheetExampleFragment.newInstance())
    }

    override fun getDescription(): String = "Modal BottomSheet"
}


class BindItemModalBottomSheet : BindDataToViewHolder<ItemModalBottomSheet> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemModalBottomSheet) {
        viewHolder.itemView.setOnClickListener {
            data.apply()
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemModalBottomSheet
    ) {
        val holder = viewHolder as FeatureViewHolderDefault
        holder.viewTitle.text = data.getDescription()
    }

}