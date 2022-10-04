package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.view.fragment.StandardBottomSheetFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault

class StandardBottomSheet(private val listener: ListenerListFragmentsViewHolder) :
    OnClickBottomSheet {

    override val description: String
        get() = "StandardBottomSheet"

    override fun run() {
        listener.onInteractWithView(StandardBottomSheetFragment.newInstance())
    }
}


class BindItemStandardBottomSheet : BindDataToViewHolder<StandardBottomSheet> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: StandardBottomSheet) {
        viewHolder.itemView.setOnClickListener {
            data.run()
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: StandardBottomSheet
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
    }

}