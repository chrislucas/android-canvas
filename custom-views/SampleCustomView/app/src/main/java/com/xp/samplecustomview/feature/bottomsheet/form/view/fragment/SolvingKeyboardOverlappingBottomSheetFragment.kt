package com.xp.samplecustomview.feature.bottomsheet.form.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.FragmentSolvingKeyboardOverlappingBottomSheetBinding
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


class SolvingKeyboardOverlappingBottomSheetFragment : Fragment(), BaseBehaviorFragment {

    private lateinit var binding: FragmentSolvingKeyboardOverlappingBottomSheetBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = FragmentSolvingKeyboardOverlappingBottomSheetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding.btOpenDialogKeyboardOverlapping.setOnClickListener {
            activity?.supportFragmentManager?.let {
                    fragmentManager ->
                val dialog = KeyboardOverlappingBottomSheetDialogFragment.newInstance()
                dialog.show(fragmentManager, KeyboardOverlappingBottomSheetDialogFragment.tag())
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SolvingKeyboardOverlappingBottomSheetFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}