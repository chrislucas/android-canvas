package com.xp.samplecustomview.feature.waterripple.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R

/**
 * Codigo para explorar o código produzido pelo autor abaixo
 * https://github.com/Johnjson/RadarAnimation
 * https://www.programmersought.com/article/76593655160/
 *
 * */
class RadarRippleEffectFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radar_ripple_effect, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RadarRippleEffectFragment()
    }
}