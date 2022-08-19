package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.view.fragment.TypeOfBottomSheetsFragment
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder

class ItemFeatureTypeOfBottomSheet(val description: String)

class BindItemFeatureTypeOfBottomSheet(private val channel: ListenerListFragmentsViewHolder) :
    BindDataToViewHolder<ItemFeatureTypeOfBottomSheet> {
    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureTypeOfBottomSheet) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(TypeOfBottomSheetsFragment.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureTypeOfBottomSheet
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
        mView.viewIcon.setImageDrawable(
            AppCompatResources.getDrawable(
                viewHolder.itemView.context,
                R.mipmap.ic_launcher_round
            )
        )
    }
}
