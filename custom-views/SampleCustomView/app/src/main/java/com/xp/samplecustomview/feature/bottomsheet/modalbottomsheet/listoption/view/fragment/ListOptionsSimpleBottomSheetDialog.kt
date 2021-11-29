package com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.LayoutBottomSheetDialogListOptionSample1Binding
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.models.MenuOption
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.list.adapter.ListOptionsAdapter
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

class ListOptionsSimpleBottomSheetDialog: BottomSheetDialogFragment(), BaseBehaviorFragment {


    lateinit var bindView: LayoutBottomSheetDialogListOptionSample1Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = LayoutBottomSheetDialogListOptionSample1Binding.inflate(layoutInflater)
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

        return bindView.root
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}


    companion object {

        @JvmStatic
        fun newInstance() = ListOptionsSimpleBottomSheetDialog()

        private val menuOptions: List<MenuOption> = (1..35).map { MenuOption("Item #$it") }

        @JvmStatic
        fun tag(): String = this::class.java.ownTag
    }
}