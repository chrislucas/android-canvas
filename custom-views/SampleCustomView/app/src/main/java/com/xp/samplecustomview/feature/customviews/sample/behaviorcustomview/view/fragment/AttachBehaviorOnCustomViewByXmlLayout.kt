package com.xp.samplecustomview.feature.customviews.sample.behaviorcustomview.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


class AttachBehaviorOnCustomViewByXmlLayout : Fragment(), BaseBehaviorFragment {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_attach_behavior_on_custom_view_by_xml_layout,
            container,
            false
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AttachBehaviorOnCustomViewByXmlLayout()
    }

    override fun getMyOwnTag(): String = javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}