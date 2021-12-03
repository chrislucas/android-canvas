package com.xp.samplecustomview.feature.galleryoffeatures.models

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewBindingFragmentViewHolder
import com.xp.samplecustomview.feature.viewbindfragment.view.fragments.SampleViewBindingFragmentBase
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder

class ItemFeatureViewBindingFragment(val description: String)


class BindItemFeatureViewBindingFragment(private val channel: ListenerListFragmentsViewHolder) :
    BindDataToViewHolder<ItemFeatureViewBindingFragment> {
    override fun onClick(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureViewBindingFragment
    ) {
        // DO NOTHING
        viewHolder.itemView.setOnClickListener {
            Toast.makeText(
                viewHolder.itemView.context,
                "Ola mundo Viewbinding Fragments",
                Toast.LENGTH_LONG
            ).show()

            channel.onInteractWithView(SampleViewBindingFragmentBase.newInstance())
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureViewBindingFragment
    ) {
        // DO NOTHING
        val vh = viewHolder as FeatureViewBindingFragmentViewHolder
        vh.tvTitle.text = data.description
    }
}