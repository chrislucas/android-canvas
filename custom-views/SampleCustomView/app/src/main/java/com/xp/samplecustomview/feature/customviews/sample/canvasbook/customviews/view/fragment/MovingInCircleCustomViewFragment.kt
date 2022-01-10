package com.xp.samplecustomview.feature.customviews.sample.canvasbook.customviews.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

class MovingInCircleCustomViewFragment : Fragment(), BaseBehaviorFragment {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_moving_in_circle_custom_view, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MovingInCircleCustomViewFragment()
    }

    override fun getMyOwnTag(): String = javaClass.ownTag


    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}