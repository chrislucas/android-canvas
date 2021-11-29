package com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.FragmentFirstExampleBottomSheetBinding
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.models.MenuOption
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.list.adapter.ListOptionsAdapter
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


/**
 * https://material.io/develop/android/components/bottom-sheet-dialog-fragment
 * */

class ListOptionsSampleBottomSheetFragment : Fragment(), BaseBehaviorFragment {


    lateinit var bindView: FragmentFirstExampleBottomSheetBinding

    private val menuOptions: List<MenuOption> = (1..35).map { MenuOption("Item $it") }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = FragmentFirstExampleBottomSheetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val recyclerViewListMenuOption = bindView.rcListOptions

        with(recyclerViewListMenuOption) {
            layoutManager = LinearLayoutManager(context)
            adapter = ListOptionsAdapter(menuOptions)
        }


        return bindView.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListOptionsSampleBottomSheetFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}