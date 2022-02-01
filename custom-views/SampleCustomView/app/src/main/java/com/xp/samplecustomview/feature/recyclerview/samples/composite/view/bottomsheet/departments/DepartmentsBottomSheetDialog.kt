package com.xp.samplecustomview.feature.recyclerview.samples.composite.view.bottomsheet.departments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private val mapDepartment: Map<Int, List<Department>> =
        departments.run {
            val map = mutableMapOf<Int, List<Department>>()
            for (dep in this) {
                map[dep.id] = dep.subDepartments
            }
            map
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

        bindView.rcDepartments.adapter = DepartmentAdapter(departments, this)
        bindView.rcSubDepartments.adapter = mutableDepartmentAdapter

        return bindView.root
    }

    override fun update(parentId: Int) {
        mapDepartment[parentId]?.let { department ->
            mutableDepartmentAdapter.mutableDepartments = departments
            mutableDepartmentAdapter.notifyItemRangeChanged(0, departments.size)
            postUpdate.post()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(departments: List<Department>) = DepartmentsBottomSheetDialog(departments)

        val TAG = DepartmentsBottomSheetDialog::class.java.ownTag
    }
}