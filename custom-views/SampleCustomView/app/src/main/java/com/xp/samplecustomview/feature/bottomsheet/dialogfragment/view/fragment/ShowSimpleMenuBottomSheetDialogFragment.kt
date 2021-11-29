package com.xp.samplecustomview.feature.bottomsheet.dialogfragment.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.FragmentSampleBottomSheetDialogBinding
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


class ShowSimpleMenuBottomSheetDialogFragment : Fragment(), BaseBehaviorFragment {

    lateinit var binderView: FragmentSampleBottomSheetDialogBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binderView = FragmentSampleBottomSheetDialogBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binderView.btOpenBottomSheetDialogFrag.setOnClickListener {
            activity?.supportFragmentManager?.let {
                val dialog = SimpleMenuBottomSheetDialogFragment.newInstance()
                dialog.show(it, SimpleMenuBottomSheetDialogFragment.tag())
            }
        }
        return binderView.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ShowSimpleMenuBottomSheetDialogFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}