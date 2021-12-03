package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.FragmentModalBottomSheetExampleBinding
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

/*
    Exemplo baseado em:
    https://medium.com/over-engineering/hands-on-with-material-components-for-android-bottom-sheet-970c5f0f1840
 */


class ModalBottomSheet private constructor() : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(
            R.layout.layout_modal_bottom_sheet_dialog_fragment_1,
            container,
            false
        )

    companion object {
        @JvmStatic
        fun getInstance() = ModalBottomSheet()

        @JvmStatic
        val TAG = this::class.java.ownTag
    }
}

class ModalBottomSheetExampleFragment : Fragment(), BaseBehaviorFragment {

    lateinit var viewBind: FragmentModalBottomSheetExampleBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewBind = FragmentModalBottomSheetExampleBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBind.btOpenModalBottomSheet.setOnClickListener {
            activity?.supportFragmentManager?.let {
                val dialog = ModalBottomSheet.getInstance()
                dialog.show(it, ModalBottomSheet.TAG)
            }
        }
        return viewBind.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ModalBottomSheetExampleFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}