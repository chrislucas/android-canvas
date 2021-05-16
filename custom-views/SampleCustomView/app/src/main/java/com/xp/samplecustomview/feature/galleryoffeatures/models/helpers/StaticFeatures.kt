package com.xp.samplecustomview.feature.galleryoffeatures.models.helpers

import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_FEATURE_CUSTOM_VIEWS
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT
import com.xp.samplecustomview.feature.galleryoffeatures.models.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
object StaticFeatures {
    /**
     * An array of sample (dummy) items.
     */
    val ITEMS:List<HolderBinderViewHolder<Any>> by lazy {
        listOf(
            HolderBinderViewHolder(
                VIEW_HOLDER_FEATURE_CUSTOM_VIEWS,
                ItemFeatureCustomView(R.string.txt_title_feature_custom_view),
                BindItemFeatureCustomView()
            ),

            HolderBinderViewHolder(
                VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT,
                ItemFeatureViewBindingFragment(R.string.txt_title_feature_view_binding_fragment),
                BindItemFeatureViewBindingFragment()
            )
        ) as List<HolderBinderViewHolder<Any>>
    }


}



