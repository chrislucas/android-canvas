package com.xp.samplecustomview.feature.toolbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R

/**
 * https://developer.android.com/training/appbar/setting-up?hl=pt-br
 */
class ConfigToolbarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_config_toolbar, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ConfigToolbarFragment()
    }
}