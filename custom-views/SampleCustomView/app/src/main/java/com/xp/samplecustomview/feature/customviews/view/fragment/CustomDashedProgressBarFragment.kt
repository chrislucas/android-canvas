package com.xp.samplecustomview.feature.customviews.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


class CustomDashedProgressBarFragment : Fragment(), BaseBehaviorFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_dashed_progress_bar, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CustomDashedProgressBarFragment()
    }

    override fun getMyOwnTag(): String = javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this
    override fun actionOnBackPressedInFragment() {}
}