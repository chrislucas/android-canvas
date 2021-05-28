package com.xp.samplecustomview.feature.galleryoffeatures.view.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.RecyclerViewAdapterGalleryOfFeatures
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_FEATURE_CUSTOM_VIEWS
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_FEATURE_LIST_DEFAULT
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT
import com.xp.samplecustomview.feature.galleryoffeatures.models.*
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.binders.BinderAdapterGalleryOfFeatures
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationFragmentActivity
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment

/**
 * A fragment representing a list of Items.
 */
class FragmentGalleryOfFeatures : Fragment(), BaseBehaviorFragment,
    ChannelCommunicationViewHolderFragment {

    private var columnCount = 2

    private lateinit var channelCommunicationFragmentActivity: ChannelCommunicationFragmentActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    private val itemsOfMenuFeature: List<HolderBinderViewHolder<Any>> by lazy {
        listOf(
            HolderBinderViewHolder(
                VIEW_HOLDER_FEATURE_CUSTOM_VIEWS,
                ItemFeatureSlideCustomView(R.string.txt_title_feature_custom_view),
                BindItemFeatureSlideCustomView(this)
            ),

            HolderBinderViewHolder(
                VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT,
                ItemFeatureViewBindingFragment(R.string.txt_title_feature_view_binding_fragment),
                BindItemFeatureViewBindingFragment(this)
            ),

            HolderBinderViewHolder(
                VIEW_HOLDER_FEATURE_LIST_DEFAULT,
                ItemFeatureCustomPopupView(R.string.txt_title_feature_custom_popup_view),
                BindItemFeatureCustomPopupView(this)
            )
        ) as List<HolderBinderViewHolder<Any>>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_layout_list_of_features, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                adapter = RecyclerViewAdapterGalleryOfFeatures(
                    itemsOfMenuFeature,
                    BinderAdapterGalleryOfFeatures()
                )
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChannelCommunicationFragmentActivity) {
            channelCommunicationFragmentActivity = context
        }
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int = 2) =
            FragmentGalleryOfFeatures().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun call(behaviorFragment: BaseBehaviorFragment) {
        channelCommunicationFragmentActivity.openThisFragment(behaviorFragment)
    }

    override fun actionOnBackPressedInFragment() {

    }
}