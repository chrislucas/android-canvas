package com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.composite.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.FragmentCompositeDepartmentsBinding
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.Department
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.sample.providerDepartments
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.sample.toTreeStructure
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.composite.view.adapters.DepartmentAdapter
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.composite.view.adapters.MutableDepartmentAdapter
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.composite.view.adapters.PostUpdateCombinedRecyclerView
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.composite.view.adapters.UpdateCombinedRecyclerVew
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

// PERSISTENT BOTTOM SHEET
class TwoListDepartmentsPersistentBottomSheetFragment private constructor() : BaseBehaviorFragment,
    UpdateCombinedRecyclerVew, Fragment() {

    private lateinit var bindView: FragmentCompositeDepartmentsBinding

    // TODO recuperar os departamentos de uma arquivo json
    private val departments = providerDepartments()
    private val mapDepartment: Map<Int, List<Department>> = toTreeStructure(departments)
    private val mutableDepartmentAdapter = MutableDepartmentAdapter(departments[0].subDepartments)
    private val postUpdate: PostUpdateCombinedRecyclerView = mutableDepartmentAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = FragmentCompositeDepartmentsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bottomSheetBehavior = BottomSheetBehavior
            .from(bindView.includeBsDepartment1.flRootBottomSheet)

        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        } else if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        bindView.includeBsDepartment1.rcDepartments.adapter = DepartmentAdapter(
            departments,
            this
        )
        bindView.includeBsDepartment1.rcSubDepartments.adapter = mutableDepartmentAdapter
        return bindView.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = TwoListDepartmentsPersistentBottomSheetFragment()
    }

    override fun update(id: Int) {
        mapDepartment[id]?.let { subDepartments ->
            val oldSize = mutableDepartmentAdapter.mutableDepartments.size
            val newSize = subDepartments.size
            mutableDepartmentAdapter.mutableDepartments = subDepartments
            mutableDepartmentAdapter.notifyItemRangeRemoved(
                0, oldSize
            )
            mutableDepartmentAdapter.notifyItemRangeInserted(
                0, newSize
            )
            postUpdate.post()
        }
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}