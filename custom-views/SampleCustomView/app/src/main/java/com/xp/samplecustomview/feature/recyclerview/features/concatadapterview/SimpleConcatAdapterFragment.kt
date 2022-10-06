package com.xp.samplecustomview.feature.recyclerview.features.concatadapterview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R

/*
    TODO estudar sobre essa classe ConcatAdapter
    https://developer.android.com/reference/androidx/recyclerview/widget/ConcatAdapter
    https://medium.com/androiddevelopers/get-ahead-using-headers-in-recyclerview-2909a69b19
 */
class SimpleConcatAdapterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_concat_adapter, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SimpleConcatAdapterFragment()
    }
}