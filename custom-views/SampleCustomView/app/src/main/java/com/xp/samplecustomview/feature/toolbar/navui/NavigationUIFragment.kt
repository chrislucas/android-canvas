package com.xp.samplecustomview.feature.toolbar.navui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R

/**
 * https://developer.android.com/guide/navigation/navigation-ui?hl=pt-br
 */
class NavigationUIFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation_u_i, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = NavigationUIFragment()
    }
}