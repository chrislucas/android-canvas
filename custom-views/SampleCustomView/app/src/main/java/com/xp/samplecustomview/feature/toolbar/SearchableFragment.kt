package com.xp.samplecustomview.feature.toolbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R

/**
 * https://developer.android.com/training/search/setup
 */
class SearchableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searcheable, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchableFragment()

    }
}