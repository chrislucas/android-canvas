package com.xp.samplecustomview.feature.galleryoffeatures.models

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.br.intentnavigation.redirectByDeeplink
import com.xp.samplecustomview.commons.view.recyclerview.action.BindDataToViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.FeatureViewHolderDefault

data class ItemFeatureResolverDeeplink(
    val description: String,
    val deeplink: String,
    val fragmentActivity: FragmentActivity
)

class BindItemFeatureResolverDeeplinkDefault :
    BindDataToViewHolder<ItemFeatureResolverDeeplink> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: ItemFeatureResolverDeeplink) {
        viewHolder.itemView.setOnClickListener {
            data.run {
                fragmentActivity.redirectByDeeplink(
                    deeplink,
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                )
            }
        }
    }

    override fun fillViewHolderWithData(
        viewHolder: RecyclerView.ViewHolder,
        data: ItemFeatureResolverDeeplink
    ) {
        val mView = viewHolder as FeatureViewHolderDefault
        mView.viewTitle.text = data.description
    }
}