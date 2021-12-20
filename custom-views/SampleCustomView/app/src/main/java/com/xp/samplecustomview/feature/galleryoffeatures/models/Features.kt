package com.xp.samplecustomview.feature.galleryoffeatures.models

import androidx.fragment.app.FragmentActivity
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.model.VIEW_HOLDER_EMPTY_STATE
import com.xp.samplecustomview.commons.view.recyclerview.model.VIEW_HOLDER_FEATURE_CUSTOM_VIEWS
import com.xp.samplecustomview.commons.view.recyclerview.model.VIEW_HOLDER_FEATURE_LIST_DEFAULT
import com.xp.samplecustomview.commons.view.recyclerview.model.VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT


fun provideFeatures(
    activity: FragmentActivity,
    communicationWithViewHolder: ListenerListFragmentsViewHolder
) =
    listOf(
        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_CUSTOM_VIEWS,
            ItemFeatureSlideCustomView(activity.getString(R.string.txt_title_feature_slider_custom_view)),
            BindItemFeatureSlideCustomView(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_CUSTOM_VIEWS,
            ItemFeatureFullscreenSlideCustomView(activity.getString(R.string.txt_title_feature_fullscreen_slider_custom_view)),
            BindItemFeatureFullscreenSlideCustomView(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT,
            ItemFeatureViewBindingFragment(activity.getString(R.string.txt_title_feature_view_binding_fragment)),
            BindItemFeatureViewBindingFragment(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureCustomPopupView(activity.getString(R.string.txt_title_feature_custom_popup_view)),
            BindItemFeatureCustomPopupView(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureDefault(activity.getString(R.string.txt_title_feature_dashed_progress_bar)),
            BindItemFeatureCustomDashedProgressBar(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureCustomBehaviorForCustomView(
                activity.getString(R.string.txt_title_feature_custom_behavior)
            ),
            BindItemFeatureCustomBehaviorForCustomView(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureRecyclerViewListAdapterWithDiffCallback(
                activity.getString(R.string.txt_title_feature_recycler_view_list_adapter)
            ),
            BindItemFeatureRecyclerViewListAdapter(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureMenuOptionBottomSheetFragment(
                activity.getString(R.string.txt_title_fragment_list_options_sample_modal_bottom_sheet)
            ),
            BindItemFeatureMenuOptionBottomSheetFragment(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureShowSimpleBottomSheetDialog(
                activity.getString(R.string.txt_title_fragment_bottom_sheet_dialog)
            ),
            BindItemFeatureShowSimpleBottomSheetDialog(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureTypeOfBottomSheet(
                activity.getString(R.string.txt_title_fragment_type_of_bottom_sheet)
            ),
            BindItemFeatureTypeOfBottomSheet(communicationWithViewHolder)
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureResolverDeeplink(
                activity.getString(R.string.txt_title_activity_first_sample_gl_renderer),
                "deeplink://main_activity_first_sample_opengl_renderer",
                activity
            ),
            BindItemFeatureResolverDeeplinkDefault()
        ),

        CompositeRecyclerViewItem(
            VIEW_HOLDER_FEATURE_LIST_DEFAULT,
            ItemFeatureResolverDeeplink(
                activity.getString(R.string.txt_title_activity_fling_anim_first_sample),
                "deeplink://fling_anim_activity_first_sample",
                activity
            ),
            BindItemFeatureResolverDeeplinkDefault()
        ),

        ) as List<CompositeRecyclerViewItem<Any>>


fun provideEmptyStateList() = listOf(
    CompositeRecyclerViewItem(
        VIEW_HOLDER_EMPTY_STATE,
        ItemEmptyStateList(),
        BindEmptyStateListViewHolder()
    )

) as List<CompositeRecyclerViewItem<Any>>