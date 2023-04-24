package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.view.fragment.ModalBottomSheetExampleFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault

class ModalBottomSheet(private val listener: ListenerListFragmentsViewHolder) :
    OnClickBottomSheet {

    override fun run() {
        listener.onInteractWithView(ModalBottomSheetExampleFragment.newInstance())
    }

    override val description: String
        get() = "Modal BottomSheet"
}


class BindItemModalBottomSheet : BindDataToViewHolder<ModalBottomSheet> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ModalBottomSheet) {
        viewHolder.itemView.setOnClickListener {
            data.run()
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ModalBottomSheet
    ) {
        val holder = viewHolder as FeatureViewHolderDefault
        holder.viewTitle.text = data.description
    }

}