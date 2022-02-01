package com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.BuildConfig
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.LayoutBottomSheetDialogListOptionSample1Binding
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.models.MenuOption
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.list.adapter.ListOptionsAdapter
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

class ListOptionsSimpleBottomSheetDialog : BottomSheetDialogFragment(), BaseBehaviorFragment {

    private lateinit var bindView: LayoutBottomSheetDialogListOptionSample1Binding

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

    private lateinit var behavior: BottomSheetBehavior<FrameLayout>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = LayoutBottomSheetDialogListOptionSample1Binding.inflate(layoutInflater)
    }

    private val menuOptions: List<MenuOption> = (1..35).map {
        MenuOption("Item #$it") {
            Toast.makeText(context, label, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        with(bindView.rcListOptions) {
            this.adapter = ListOptionsAdapter(menuOptions)
            this.layoutManager = LinearLayoutManager(context)
        }

        val bottomSheetDialog = dialog as BottomSheetDialog
        behavior = BottomSheetBehavior.from(bindView.flRootBottomSheet)
        println(
            "Is ${
                if (bottomSheetDialog.behavior == behavior) {
                    " the same behavior"
                } else {
                    " not the same behavior\n${bottomSheetDialog.behavior}\n$behavior"
                }
            } "
        )

        return bindView.root
    }

    override fun onResume() {
        super.onResume()
        behavior.addBottomSheetCallback(bottomSheetCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        behavior.removeBottomSheetCallback(bottomSheetCallback)
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}

    companion object {

        @JvmStatic
        fun newInstance() = ListOptionsSimpleBottomSheetDialog()

        @JvmStatic
        fun tag(): String = this::class.java.ownTag
    }
}