package com.xp.samplecustomview.feature.galleryoffeatures.models

import android.content.Context
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_EMPTY_STATE
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_FEATURE_CUSTOM_VIEWS
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_FEATURE_LIST_DEFAULT
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.ListenerFeaturesViewHolder


fun provideFeatures(
    ctx: Context,
    communicationWithViewHolder: ListenerFeaturesViewHolder
) =
    listOf(
        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_CUSTOM_VIEWS,
            ItemFeatureSlideCustomView(ctx.getString(R.string.txt_title_feature_slider_custom_view)),
            BindItemFeatureSlideCustomView(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT,
            ItemFeatureViewBindingFragment(ctx.getString(R.string.txt_title_feature_view_binding_fragment)),
            BindItemFeatureViewBindingFragment(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureCustomPopupView(ctx.getString(R.string.txt_title_feature_custom_popup_view)),
            BindItemFeatureCustomPopupView(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureDefault(ctx.getString(R.string.txt_title_feature_dashed_progress_bar)),
            BindItemFeatureCustomDashedProgressBar(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureCustomBehaviorForCustomView(
                ctx.getString(R.string.txt_title_feature_custom_behavior)
            ),
            BindItemFeatureCustomBehaviorForCustomView(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureRecyclerViewListAdapterWithDiffCallback(
                ctx.getString(R.string.txt_title_feature_recycler_view_list_adapter)
            ),
            BindItemFeatureRecyclerViewListAdapter(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureMenuOptionBottomSheetFragment(
                ctx.getString(R.string.txt_title_fragment_list_options_sample_modal_bottom_sheet)
            ),
            BindItemFeatureMenuOptionBottomSheetFragment(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureShowSimpleBottomSheetDialog(
                ctx.getString(R.string.txt_title_fragment_bottom_sheet_dialogt)
            ),
            BindItemFeatureShowSimpleBottomSheetDialog(communicationWithViewHolder)
        )
    ) as List<CompositeRecyclerViewItem<Any>>


fun provideEmptyStateList() = listOf(
    CompositeRecyclerViewItem(
        VIEW_HOLDER_EMPTY_STATE,
        ItemEmptyStateList(),
        BindEmptyStateListViewHolder()
    )

) as List<CompositeRecyclerViewItem<Any>>