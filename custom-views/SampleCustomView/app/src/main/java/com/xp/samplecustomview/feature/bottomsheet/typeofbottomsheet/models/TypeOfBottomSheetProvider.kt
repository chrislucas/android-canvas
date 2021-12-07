package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models

import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.model.VIEW_HOLDER_FEATURE_LIST_DEFAULT
import com.xp.samplecustomview.feature.galleryoffeatures.models.CompositeRecyclerViewItem

internal fun providerTypesOfBottomSheet(listener: ListenerListFragmentsViewHolder) =
    listOf<CompositeRecyclerViewItem<out MetadataListItem>>(
        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemStandardBottomSheet(listener),
            BindItemStandardBottomSheet(),
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemModalBottomSheet(listener),
            BindItemModalBottomSheet(),
        )
    )