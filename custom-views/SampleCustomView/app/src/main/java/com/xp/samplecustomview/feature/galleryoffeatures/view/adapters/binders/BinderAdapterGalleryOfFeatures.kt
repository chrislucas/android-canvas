package com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.binders

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.action.SimpleBindViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.viewholder.helper.BuilderViewHolder

class BinderAdapterGalleryOfFeatures : SimpleBindViewHolder {

    override fun getViewHolder(viewType: Int, viewRoot: ViewGroup): RecyclerView.ViewHolder =
        BuilderViewHolder.build(viewType, viewRoot)

}