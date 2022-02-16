package com.xp.samplecustomview.feature.recyclerview.samples.composite.view.bottomsheet.departments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.commons.view.recyclerview.model.VIEW_HOLDER_FEATURE_LIST_DEFAULT
import com.xp.samplecustomview.databinding.BottomSheetDepartmentsMultipleRecyclerViewBinding
import com.xp.samplecustomview.feature.recyclerview.samples.composite.models.Department
import com.xp.samplecustomview.feature.recyclerview.samples.composite.models.sample.toTreeStructure
import com.xp.samplecustomview.feature.recyclerview.samples.composite.view.adapters.*
import com.xp.samplecustomview.feature.recyclerview.samples.composite.view.holder.HorizontalRecyclerViewViewHolder

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
        configRecyclerView()

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

    private fun configRecyclerView() {
        val recyclerViews = mutableListOf<RecyclerView>()

        fun add(recyclerView: RecyclerView, departments: List<Department>) {
            recyclerView.adapter = addAdapter(recyclerView, departments)
        }

        val recycler = createRecyclerView()
        add(recycler, departments)
        recyclerViews += recycler


        mapDepartment.keys.forEach { key ->
            mapDepartment[key]?.let {
                val recyclerView = createRecyclerView()
                add(recyclerView, it)
                recyclerViews += recyclerView
            }
        }

        bindView.rcMultilevel.adapter = TreeStructureAdapter(recyclerViews)

    }

    private fun createRecyclerView(): RecyclerView {
        return LayoutInflater.from(context)
            .inflate(
                R.layout.layout_item_feature_horizontal_recycler_view,
                bindView.rcMultilevel,
                false
            ) as RecyclerView
    }

    private fun addAdapter(recyclerView: RecyclerView, departments: List<Department>):
            AdapterForRecyclerViewInTreeStructure<Department> {
        val items = departments.map { department ->
            val binder = object : BindDataViewHolder<Department> {
                override fun onClick(
                    viewHolder: RecyclerView.ViewHolder,
                    data: Department
                ) {
                    println(data)
                }

                override fun fillViewHolderWithData(
                    viewHolder: RecyclerView.ViewHolder,
                    data: Department
                ) {
                    println(data)
                }
            }
            Item(VIEW_HOLDER_FEATURE_LIST_DEFAULT, department, binder)
        }

        return AdapterForRecyclerViewInTreeStructure(items, getBindViewHolder(recyclerView))
    }

    private fun getBindViewHolder(root: View): BindViewHolder {
        return object : BindViewHolder {
            override fun getViewHolder(
                viewRoot: ViewGroup,
                viewType: Int
            ): RecyclerView.ViewHolder {
                return HorizontalRecyclerViewViewHolder(root)
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