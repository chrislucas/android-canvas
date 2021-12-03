package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.BuildConfig
import com.xp.samplecustomview.commons.ext.onClick
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.FragmentStandardBottomSheetBinding
import com.xp.samplecustomview.databinding.LayoutStandardBottomSheetDialogFragment1Binding
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


/*
    Exemplo baseado no link abaixo
    https://medium.com/over-engineering/hands-on-with-material-components-for-android-bottom-sheet-970c5f0f1840
 */

class StandardBottomSheet private constructor() : BottomSheetDialogFragment() {


    lateinit var bindView: LayoutStandardBottomSheetDialogFragment1Binding

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ViewGroup>

    @BottomSheetBehavior.State
    private var bottomSheetBehaviorState: Int = BottomSheetBehavior.STATE_HALF_EXPANDED

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = LayoutStandardBottomSheetDialogFragment1Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bottomSheetBehavior = BottomSheetBehavior.from(bindView.llStandardBottomSheet)

        val mDialog = dialog as BottomSheetDialog


        bindView.clLayoutModalBottomSheetListBehavior.tvBehaviorExpanded.onClick {
            bottomSheetBehaviorState = BottomSheetBehavior.STATE_EXPANDED
            mDialog.dismiss()
        }

        bindView.clLayoutModalBottomSheetListBehavior.tvBehaviorDragging.onClick {
            bottomSheetBehaviorState = BottomSheetBehavior.STATE_DRAGGING
            mDialog.dismiss()
        }

        bindView.clLayoutModalBottomSheetListBehavior.tvBehaviorCollapse.onClick {
            bottomSheetBehaviorState = BottomSheetBehavior.STATE_COLLAPSED
            mDialog.dismiss()
        }


        mDialog.setOnShowListener {
            setBottomSheetBehaviorState(bottomSheetBehaviorState)
        }

        return bindView.root
    }

    private fun setBottomSheetBehaviorState(@BottomSheetBehavior.State state: Int) {
        BottomSheetBehavior.from(bindView.llStandardBottomSheet).state = state
    }


    override fun onResume() {
        super.onResume()
        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        bottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback)
    }


    private val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            Log.i("ON_STATE_CHANGED", "ON_STATE_CHANGED")
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            if (BuildConfig.DEBUG) {
                Log.i("ON_SLIDE", "ON_SLIDE offset: $slideOffset")
            }
        }
    }

    companion object {
        @JvmStatic
        fun getInstance() = StandardBottomSheet()

        @JvmStatic
        val TAG = this::class.java.ownTag
    }
}


class StandardBottomSheetFragment : Fragment(), BaseBehaviorFragment {

    lateinit var bindView: FragmentStandardBottomSheetBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = FragmentStandardBottomSheetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        bindView.btOpenStandardBottomSheet.setOnClickListener {
            activity?.supportFragmentManager?.let {
                val bottomSheetDialog = StandardBottomSheet.getInstance()
                bottomSheetDialog.show(it, StandardBottomSheet.TAG)
            }
        }
        return bindView.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            StandardBottomSheetFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}