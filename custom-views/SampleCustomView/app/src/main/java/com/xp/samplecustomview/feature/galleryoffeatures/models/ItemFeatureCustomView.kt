package com.xp.samplecustomview.feature.galleryoffeatures.models

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.customviews.view.fragment.CustomViewsFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureCustomViews
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment


class ItemFeatureCustomView(@StringRes val description: Int)


class BindItemFeatureCustomView(private val channel: ChannelCommunicationViewHolderFragment) : BindDataToViewHolder<ItemFeatureCustomView> {
    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureCustomView) {
        // DO NOTHING
        viewHolder.itemView.setOnClickListener {
            Toast.makeText(viewHolder.itemView.context, "Ola mundo Custom Views", Toast.LENGTH_LONG).show()
            channel.call(CustomViewsFragment.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureCustomView
    ) {
        // DO NOTHING
        val vh = viewHolder as FeatureCustomViews
        vh.tvTitle.text = viewHolder.itemView.context.getString(data.description)
    }
}

