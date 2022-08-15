package com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.FragmentTreeStructureDepartmentMultipleRecyclerViewsBinding
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.sample.providerComplexityStructureDepartment
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.bottomsheet.TreeStructureDepartmentsBottomSheetDialog
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


class TreeStructureDepartmentsBottomSheetDialogsFragment : BaseBehaviorFragment, Fragment() {

    private lateinit var bindView: FragmentTreeStructureDepartmentMultipleRecyclerViewsBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = FragmentTreeStructureDepartmentMultipleRecyclerViewsBinding
            .inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.supportFragmentManager?.let { fm ->
            val dialog = TreeStructureDepartmentsBottomSheetDialog
                .newInstance(providerComplexityStructureDepartment())
            dialog.show(fm, TreeStructureDepartmentsBottomSheetDialog.TAG)
        }
        return bindView.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = TreeStructureDepartmentsBottomSheetDialogsFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}