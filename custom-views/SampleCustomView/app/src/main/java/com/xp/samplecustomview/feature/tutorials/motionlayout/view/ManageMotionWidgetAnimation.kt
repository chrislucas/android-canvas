package com.xp.samplecustomview.feature.tutorials.motionlayout.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R

/**
 * Manage motion and widget animation with MotionLayout
 * https://developer.android.com/training/constraint-layout/motionlayout
 */
class ManageMotionWidgetAnimation : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manage_motion_widget_animation, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ManageMotionWidgetAnimation()
    }
}