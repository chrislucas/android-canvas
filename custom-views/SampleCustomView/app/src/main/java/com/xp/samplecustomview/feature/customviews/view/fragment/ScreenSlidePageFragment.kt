package com.xp.samplecustomview.feature.customviews.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R

class ScreenSlidePageFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ScreenSlidePageFragment()
    }
}