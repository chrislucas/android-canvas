package com.xp.samplecustomview.feature.coloroptions.view.fragments

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
 */
class ColorOptionsViewFragmentBase : Fragment(), BaseBehaviorFragment {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color_options_view, container, false)
    }

    override fun getMyOwnTag(): String =  this.javaClass.ownTag

    override fun getInstanceFragment() = this
}
