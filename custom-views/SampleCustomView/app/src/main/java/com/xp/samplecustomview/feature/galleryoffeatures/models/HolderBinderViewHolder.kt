package com.xp.samplecustomview.feature.galleryoffeatures.models

import com.xp.samplecustomview.commons.view.recyclerview.action.LayoutBuilder
import com.xp.samplecustomview.commons.view.recyclerview.action.ViewType
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.actions.BindDataToViewHolder


class HolderBinderViewHolder<T>(
    @ViewType val viewType: Int,
    val item: T,
    val binder: BindDataToViewHolder<T>
) : LayoutBuilder {
    override fun getItemViewType(): Int = viewType
}
