package com.xp.samplecustomview.feature.galleryoffeatures.models

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureViewBindingFragmentViewHolder

class ItemFeatureViewBindingFragment(@StringRes val description: Int)


class BindItemFeatureViewBindingFragment : BindDataToViewHolder<ItemFeatureViewBindingFragment> {
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

        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureViewBindingFragment
    ) {
        // DO NOTHING
        val vh = viewHolder as FeatureViewBindingFragmentViewHolder
        vh.tvTitle.text = viewHolder.itemView.context.getString(data.description)
    }
}