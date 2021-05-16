package com.xp.samplecustomview.feature.galleryoffeatures.view.fragments

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
import com.xp.samplecustomview.feature.galleryoffeatures.models.helpers.StaticFeatures
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.binders.BinderAdapterGalleryOfFeatures

/**
 * A fragment representing a list of Items.
 */
class FragmentGalleryOfFeatures : Fragment(), BaseBehaviorFragment {

    private var columnCount = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
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
                    StaticFeatures.ITEMS,
                    BinderAdapterGalleryOfFeatures()
                )
            }
        }
        return view
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
}