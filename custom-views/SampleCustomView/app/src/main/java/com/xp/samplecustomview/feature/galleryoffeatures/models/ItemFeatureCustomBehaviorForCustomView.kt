package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.feature.customviews.sample.behaviorcustomview.view.fragment.AttachBehaviorOnCustomViewByXmlLayout
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault

class ItemFeatureCustomBehaviorForCustomView(val description: String)

class BindItemFeatureCustomBehaviorForCustomView(private val channel: ListenerListFragmentsViewHolder) :
    BindDataToViewHolder<ItemFeatureCustomBehaviorForCustomView> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureCustomBehaviorForCustomView
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.onInteractWithView(AttachBehaviorOnCustomViewByXmlLayout.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureCustomBehaviorForCustomView
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
        val img = ContextCompat.getDrawable(mView.itemView.context,
            R.mipmap.ic_launcher_round)
        mView.viewIcon.setImageDrawable(
            img
        )
    }
}