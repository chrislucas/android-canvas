package com.xp.samplecustomview.feature.recyclerview.features.itemdecoration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R


/*
    links de estudo
    https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.ItemDecoration
    https://stackoverflow.com/questions/24618829/how-to-add-dividers-and-spaces-between-items-in-recyclerview
 */

class RecyclerViewItemDecoration1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view_item_decoration_1, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecyclerViewItemDecoration1Fragment()
    }
}