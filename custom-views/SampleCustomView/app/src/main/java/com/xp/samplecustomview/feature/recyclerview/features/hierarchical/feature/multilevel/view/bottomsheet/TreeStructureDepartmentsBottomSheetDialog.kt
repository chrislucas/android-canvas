package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.view
.bottomsheet

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.BuildConfig
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.BottomSheetDepartmentsMultipleRecyclerViewBinding
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.adapter.LevelData
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.adapter.MultiLevelRecyclerViewAdapter
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.Department
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.DepartmentStruct
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.createDepartmentStruct
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.iterativeCreateTreeDepartmentStruct
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.view.adapters.HorizontalDepartmentAdapter

class TreeStructureDepartmentsBottomSheetDialog
private constructor(private val departments: List<Department>) :
    BottomSheetDialogFragment(), HorizontalDepartmentAdapter.OnClickDepartment {


    init {
        if (BuildConfig.DEBUG) {
            with(iterativeCreateTreeDepartmentStruct(departments)) {
                if (BuildConfig.DEBUG) {
                    Log.i("DEPARTMENTS", "$this")
                }
            }
        }
    }


    private val departmentStruct: DepartmentStruct =
        createDepartmentStruct(departments)

    private val mapDepartment: Map<Department, List<Department>> =
        departmentStruct.departmentTree

    private lateinit var bindView: BottomSheetDepartmentsMultipleRecyclerViewBinding

    private val mapLevelData = mapOf(0 to mutableListOf(createLevelData(departments)))

    private val adapter: MultiLevelRecyclerViewAdapter<HorizontalDepartmentAdapter> =
        MultiLevelRecyclerViewAdapter(mapLevelData)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = BottomSheetDepartmentsMultipleRecyclerViewBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        configBottomSheet()
        bindView.rcMultilevel.adapter = adapter
        return bindView.root
    }

    private fun configBottomSheet() {
        val bottomSheetBehavior = BottomSheetBehavior.from(bindView.llWrapperRecyclerView)
        val bottomSheetDialog = dialog as BottomSheetDialog

        if (Log.isLoggable(TAG, Log.INFO)) {
            Log.i(TAG, "${bottomSheetBehavior.state}")
        }

        bottomSheetDialog.setOnShowListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

        bottomSheetDialog.setOnDismissListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }

    private fun createLevelData(departments: List<Department>) =
        LevelData(
            HorizontalDepartmentAdapter(departments, this),
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        )


    private fun chooseDepartment(department: Department) {
        mapDepartment[department]?.let { subDepartments ->
            departmentStruct.level[department]?.let { level ->
                if (BuildConfig.DEBUG) {
                    Log.i(TAG, "$level, $subDepartments")
                }
                val levelSubDepartment = createLevelData(subDepartments)
                adapter.updateLevel(level, listOf(levelSubDepartment))
            }
        }
    }

    override fun onClick(department: Department) {
        chooseDepartment(department)
    }

    companion object {

        val TAG = TreeStructureDepartmentsBottomSheetDialog::class.java.ownTag

        @JvmStatic
        fun newInstance(departments: List<Department>) =
            TreeStructureDepartmentsBottomSheetDialog(departments)
    }
}