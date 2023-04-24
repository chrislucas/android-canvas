package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder


open class ItemFeatureDefault(val description: String)

open class BindItemFeatureDefaultForFragment(
    private val channel: ListenerListFragmentsViewHolder,
    val baseBehaviorFragment: BaseBehaviorFragment
) : BindDataToViewHolder<ItemFeatureDefault> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureDefault) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(baseBehaviorFragment)
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureDefault
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
    }
}


class BindItemFeatureDefaultActivity : BindDataToViewHolder<ItemFeatureDefault> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureDefault) {
        viewHolder.itemView.setOnClickListener {

        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureDefault
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
    }

}