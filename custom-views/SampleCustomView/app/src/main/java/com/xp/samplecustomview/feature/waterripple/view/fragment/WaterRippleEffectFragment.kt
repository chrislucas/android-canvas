package com.xp.samplecustomview.feature.waterripple.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.databinding.FragmentWaterRippleEffectBinding


class WaterRippleEffectFragment : Fragment() {

    private lateinit var binding: FragmentWaterRippleEffectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // https://developer.android.com/topic/libraries/view-binding#fragments

        binding = FragmentWaterRippleEffectBinding.inflate(inflater, container, false)


        return binding.viewRoot
    }

    companion object {
        @JvmStatic
        fun newInstance() = WaterRippleEffectFragment()
    }
}