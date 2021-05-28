package com.xp.samplecustomview.feature.customviews.view.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.br.bookcustomview.popupview.BuilderCustomPopupView
import com.br.bookcustomview.popupview.LayoutParamsDimension
import com.br.bookcustomview.popupview.OffsetLocation
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


class CustomPopupViewFragment : Fragment(), BaseBehaviorFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val viewRoot = inflater.inflate(R.layout.fragment_custom_popup_view, container, false)


        viewRoot.findViewById<Button>(R.id.bt_control_custom_view).setOnClickListener {
            val popupView = BuilderCustomPopupView.create(
                requireContext(),
                LayoutParamsDimension(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ), R.layout.layout_custom_popup_view_1
            )

            popupView.showAtLocation(
                viewRoot,
                OffsetLocation(0, 0, Gravity.START or Gravity.CENTER_HORIZONTAL)
            )

            popupView.contentView.findViewById<Button>(R.id.bt_close_popup_view)?.let {
                it.setOnClickListener {
                    popupView.dismiss()
                }
            }
        }


        return viewRoot
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CustomPopupViewFragment()
    }

    override fun getMyOwnTag(): String = javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}