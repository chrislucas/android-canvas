package com.xp.samplecustomview.feature.galleryoffeatures.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.commons.view.recyclerview.action.DefaultSimpleBindViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.models.HolderBinderViewHolder
import com.xp.samplecustomview.feature.galleryoffeatures.models.provideEmptyStateList
import com.xp.samplecustomview.feature.galleryoffeatures.models.provideFeatures
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.RecyclerViewAdapterGalleryOfFeatures
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.ListenerFeaturesViewHolder
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationFragmentActivity

/**
 * A fragment representing a list of Items.
 */
class GalleryOfFeatures : Fragment(), BaseBehaviorFragment,
    ListenerFeaturesViewHolder {

    private var columnCount = 2

    private lateinit var channelCommunicationFragmentActivity: ChannelCommunicationFragmentActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    private val itemsOfMenuFeature: List<HolderBinderViewHolder<Any>> by lazy {
        this.context?.let {
            provideFeatures(it, this)
        } ?: provideEmptyStateList()
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
                    DefaultSimpleBindViewHolder()
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
            GalleryOfFeatures().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun onInteractWithView(behaviorFragment: BaseBehaviorFragment) {
        channelCommunicationFragmentActivity.openThisFragment(behaviorFragment)
    }

    override fun actionOnBackPressedInFragment() {}
}