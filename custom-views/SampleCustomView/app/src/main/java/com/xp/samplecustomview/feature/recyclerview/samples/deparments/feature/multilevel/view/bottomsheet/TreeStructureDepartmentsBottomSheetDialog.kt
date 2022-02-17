package com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.bottomsheet

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.BottomSheetDepartmentsMultipleRecyclerViewBinding
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.adapters.HorizontalDepartmentAdapter
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.adapters.LevelData
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.adapters.MultiLevelRecyclerViewAdapter
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.Department
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.sample.toTreeStructure

class TreeStructureDepartmentsBottomSheetDialog private constructor(private val departments: List<Department>) :
    BottomSheetDialogFragment() {

    private val mapDepartment: Map<Int, List<Department>> = toTreeStructure(departments)

    private lateinit var bindView: BottomSheetDepartmentsMultipleRecyclerViewBinding

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
        createRecyclerViewData()
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

    private fun createRecyclerViewData() {
        val recyclerViews = mutableListOf<LevelData<HorizontalDepartmentAdapter>>()
        val adapter = LevelData(
            HorizontalDepartmentAdapter(departments),
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        )
        recyclerViews += adapter
        mapDepartment.keys.forEach { key ->
            mapDepartment[key]?.let { departments ->
                recyclerViews += LevelData(
                    HorizontalDepartmentAdapter(departments),
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                )
            }
        }

        with(bindView.rcMultilevel) {
            this.adapter = MultiLevelRecyclerViewAdapter(recyclerViews)
        }
    }

    companion object {

        val TAG = TreeStructureDepartmentsBottomSheetDialog::class.java.ownTag

        @JvmStatic
        fun newInstance(departments: List<Department>) =
            TreeStructureDepartmentsBottomSheetDialog(departments)
    }
}