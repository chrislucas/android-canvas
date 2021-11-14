package com.xp.samplecustomview.feature.customviews.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

class ScreenSliderCustomViewFragment : Fragment(), BaseBehaviorFragment {


    lateinit var slider: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
        slider = view.findViewById(R.id.sliderViewPager)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ScreenSliderCustomViewFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {
        // TODO
    }
}