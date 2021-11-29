package com.xp.samplecustomview.feature.bottomsheet.dialogfragment.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.LayoutBottomSheetFragmentDialogSample1Binding

class SimpleMenuBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private var binder: LayoutBottomSheetFragmentDialogSample1Binding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binder = LayoutBottomSheetFragmentDialogSample1Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ref = this
        return binder?.run {
            this.tvDelete.setOnClickListener {
                Toast.makeText(context, "DELETE", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            this.tvShare.setOnClickListener {
                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            this.tvUpload.setOnClickListener {
                Toast.makeText(context, "Uplpoad", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            this.root
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SimpleMenuBottomSheetDialogFragment()

        @JvmStatic
        fun tag(): String = this::class.java.ownTag
    }
}