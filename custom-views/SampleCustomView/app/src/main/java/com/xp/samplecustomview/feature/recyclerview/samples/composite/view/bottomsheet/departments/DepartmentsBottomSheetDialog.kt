package com.xp.samplecustomview.feature.recyclerview.samples.composite.view.bottomsheet.departments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.LayoutBottomSheetDialogDepartmentsBinding
import com.xp.samplecustomview.feature.recyclerview.samples.composite.models.Department
import com.xp.samplecustomview.feature.recyclerview.samples.composite.view.adapters.DepartmentAdapter
import com.xp.samplecustomview.feature.recyclerview.samples.composite.view.adapters.MutableDepartmentAdapter
import com.xp.samplecustomview.feature.recyclerview.samples.composite.view.adapters.PostUpdateCombinedRecyclerView
import com.xp.samplecustomview.feature.recyclerview.samples.composite.view.adapters.UpdateCombinedRecyclerVew

class DepartmentsBottomSheetDialog private constructor(private val departments: List<Department>) :
    BottomSheetDialogFragment(), UpdateCombinedRecyclerVew {

    private lateinit var bindView: LayoutBottomSheetDialogDepartmentsBinding

    private val mapDepartment: Map<Int, List<Department>> = mappingDepartment()

    private fun mappingDepartment(): Map<Int, List<Department>> {

        val tree = linkedMapOf<Int, List<Department>>()

        fun builder(department: Department?, map: LinkedHashMap<Int, List<Department>>) {
            if (department == null) {
                return
            } else {
                if (department.subDepartments.isNotEmpty()) {
                    map[department.id] = department.subDepartments
                    for (subDepartment in department.subDepartments) {
                        builder(subDepartment, map)
                    }
                }
            }
        }
        departments.forEach { builder(it, tree) }
        return tree
    }

    private val mutableDepartmentAdapter = MutableDepartmentAdapter(departments[0].subDepartments)

    private val postUpdate: PostUpdateCombinedRecyclerView = mutableDepartmentAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = LayoutBottomSheetDialogDepartmentsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val bottomSheetBehavior = BottomSheetBehavior.from(bindView.flRootBottomSheet)
        val bottomSheetDialog = dialog as BottomSheetDialog

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetDialog.setOnShowListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        bottomSheetDialog.setOnDismissListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        bindView.rcDepartments.adapter = DepartmentAdapter(departments, this)
        bindView.rcSubDepartments.adapter = mutableDepartmentAdapter
        return bindView.root
    }


    private fun max(p: Int, q: Int) = if (p > q) p else q

    override fun update(id: Int) {
        mapDepartment[id]?.let { subDepartments ->

            mutableDepartmentAdapter.mutableDepartments = subDepartments
            bindView.rcSubDepartments.recycledViewPool.clear()
            /*
            mutableDepartmentAdapter.notifyItemRangeChanged(0
                , subDepartments.size -1)

             */
            mutableDepartmentAdapter.notifyDataSetChanged()
            postUpdate.post()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(departments: List<Department>) = DepartmentsBottomSheetDialog(departments)

        val TAG = DepartmentsBottomSheetDialog::class.java.ownTag
    }
}