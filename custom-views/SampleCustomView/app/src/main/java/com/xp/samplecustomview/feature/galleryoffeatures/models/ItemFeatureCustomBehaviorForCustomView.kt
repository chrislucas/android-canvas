package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.feature.customviews.sample.behaviorcustomview.view.fragment.AttachBehaviorOnCustomViewByXmlLayout
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureViewHolderDefault
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment

class ItemFeatureCustomBehaviorForCustomView(val description: String)


class BindItemFeatureCustomBehaviorForCustomView(private val channel: ChannelCommunicationViewHolderFragment) :
    BindDataToViewHolder<ItemFeatureCustomBehaviorForCustomView> {

    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureCustomBehaviorForCustomView
    ) {
        viewHolder.itemView.setOnClickListener {
            channel.call(AttachBehaviorOnCustomViewByXmlLayout.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureCustomBehaviorForCustomView
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
        mView.viewIcon.setImageDrawable(
            AppCompatResources.getDrawable(
                viewHolder.itemView.context,
                R.mipmap.ic_custom_view_round
            )
        )
    }
}