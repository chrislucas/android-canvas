package com.xp.samplecustomview.feature.beziercurve.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


/**
 * A simple [Fragment] subclass.
 * Use the [SlideCustomBezierCurveViewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SlideCustomBezierCurveViewsFragment : Fragment(), BaseBehaviorFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slide_custom_bezier_curve_views, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SlideCustomBezierCurveViewsFragment()
    }

    override fun getMyOwnTag(): String = javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}