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
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.adapter.MultiLevelRecyclerViewAdapter
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.adapter.MultiLevelRecyclerViewAdapter.MultiLevelAdapterStruct
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.Department
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.DepartmentStruct
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.helper.createDepartmentStruct
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.helper.iterativeCreateTreeDepartmentStruct
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.helper.titlePerLevelMock
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.helper.toMapSection
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.view.adapters.HorizontalDepartmentAdapter

class TreeStructureDepartmentsBottomSheetDialog
private constructor(departments: List<Department>) :
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
        departmentStruct.departmentStruct

    private lateinit var viewBinding: BottomSheetDepartmentsMultipleRecyclerViewBinding

    private val multiLevelRecyclerViewAdapter: MultiLevelRecyclerViewAdapter<HorizontalDepartmentAdapter> =
        MultiLevelRecyclerViewAdapter(
            mutableMapOf(0 to createMultiLevelAdapterData(departments))
        )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewBinding = BottomSheetDepartmentsMultipleRecyclerViewBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        configBottomSheet()
        viewBinding.rcMultilevel.adapter = multiLevelRecyclerViewAdapter
        return viewBinding.root
    }

    private fun configBottomSheet() {
        val bottomSheetBehavior = BottomSheetBehavior.from(viewBinding.llWrapperRecyclerView)
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

    private fun createMultiLevelAdapterData(departments: List<Department>):
            MultiLevelAdapterStruct<HorizontalDepartmentAdapter> {

        val level = departmentStruct.departmentLevel[departments[0]] ?: 0

        val titleSection = titlePerLevelMock(level)

        return MultiLevelAdapterStruct(
            HorizontalDepartmentAdapter(departments, this),
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
    }


    override fun onClick(department: Department) {
        mapDepartment[department]?.let { subDepartments ->
            departmentStruct.departmentLevel[department]?.let { parentLevel ->
                val childLevel = parentLevel + 1
                if (BuildConfig.DEBUG) {
                    Log.i(TAG, "$childLevel, $subDepartments")
                }
                multiLevelRecyclerViewAdapter.updateLevel(
                    childLevel,
                    createMultiLevelAdapterData(subDepartments)
                )
            }
        }
    }

    companion object {

        val TAG = TreeStructureDepartmentsBottomSheetDialog::class.java.ownTag

        @JvmStatic
        fun newInstance(departments: List<Department>) =
            TreeStructureDepartmentsBottomSheetDialog(departments)
    }
}