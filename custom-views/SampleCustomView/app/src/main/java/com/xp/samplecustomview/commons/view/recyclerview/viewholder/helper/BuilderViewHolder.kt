package com.xp.samplecustomview.commons.view.recyclerview.viewholder.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.view.recyclerview.action.*
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureColorOptionsViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureCustomViews
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureViewBindingFragmentViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders.FeatureViewHolderDefault
import java.lang.IllegalArgumentException

object BuilderViewHolder {

    @JvmStatic
    fun build(
        @ViewType viewType: Int,
        viewGroup: ViewGroup,
        defaultBuilder: (() -> RecyclerView.ViewHolder)? = null
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_HOLDER_EMPTY_STATE -> {
                EmptyStateViewHolder(getView(viewGroup, R.layout.layout_item_feature_default))
            }
            VIEW_HOLDER_FEATURE_LIST_DEFAULT -> {
                FeatureViewHolderDefault(getView(viewGroup, R.layout.layout_item_feature_default))
            }

            VIEW_HOLDER_FEATURE_CUSTOM_VIEWS -> {
                FeatureCustomViews(getView(viewGroup, R.layout.layout_item_feature_custom_views))
            }

            VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT -> {
                FeatureViewBindingFragmentViewHolder(getView(viewGroup, R.layout.layout_item_feature_default))
            }

            VIEW_HOLDER_FEATURE_COLOR_OPTIONS -> {
                FeatureColorOptionsViewHolder(getView(viewGroup, R.layout.layout_item_feature_default))
            }
            else -> {
                defaultBuilder?.run {
                    this()
                }
                    ?: throw IllegalArgumentException(
                        "Nenhum ViewType foi identificado e a funcao" +
                                " de construir ViewHolder nao foi definida"
                    )
            }
        }
    }

    private fun getView(viewGroup: ViewGroup, @LayoutRes layout: Int): View =
        LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false)
}