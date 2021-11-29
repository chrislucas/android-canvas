package com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.FragmentFirstExampleBottomSheetBinding
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


/**
 * https://material.io/develop/android/components/bottom-sheet-dialog-fragment
 * */

class ShowListOptionsSimpleBottomSheetDialogFragment : Fragment(), BaseBehaviorFragment {

    lateinit var bindView: FragmentFirstExampleBottomSheetBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = FragmentFirstExampleBottomSheetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        bindView.btOpenBottomSheetDialogFragListOptions.setOnClickListener {
            activity?.supportFragmentManager?.let {
                fragmentManager ->
                val dialog = ListOptionsSimpleBottomSheetDialog.newInstance()
                dialog.show(fragmentManager, ListOptionsSimpleBottomSheetDialog.tag())
            }
        }

        return bindView.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ShowListOptionsSimpleBottomSheetDialogFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}