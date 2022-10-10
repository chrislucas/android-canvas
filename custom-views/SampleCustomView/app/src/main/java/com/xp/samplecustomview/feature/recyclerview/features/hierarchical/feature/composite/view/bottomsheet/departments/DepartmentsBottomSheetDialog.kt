package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.composite.view.bottomsheet.departments

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
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.Department
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.helper.createMapDepartment
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.composite.view.adapters.DepartmentAdapter
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.composite.view.adapters.MutableDepartmentAdapter
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.composite.view.adapters.PostUpdateCombinedRecyclerView
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.composite.view.adapters.UpdateCombinedRecyclerVew

class DepartmentsBottomSheetDialog private constructor(private val departments: List<Department>) :
    BottomSheetDialogFragment(), UpdateCombinedRecyclerVew {

    private lateinit var bindView: LayoutBottomSheetDialogDepartmentsBinding

    private val mapDepartment: Map<Int, List<Department>> = createMapDepartment(departments)

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

        val bottomSheetBehavior =
            BottomSheetBehavior.from(bindView.bottomSheetDepartment.flRootBottomSheet)
        val bottomSheetDialog = dialog as BottomSheetDialog

        //bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        bottomSheetDialog.setOnShowListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        bottomSheetDialog.setOnDismissListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            // bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        bindView.bottomSheetDepartment.rcDepartments.adapter = DepartmentAdapter(departments, this)
        bindView.bottomSheetDepartment.rcSubDepartments.adapter = mutableDepartmentAdapter
        return bindView.root
    }

    override fun update(id: Int) {
        mapDepartment[id]?.let { subDepartments ->

            val oldSize = mutableDepartmentAdapter.mutableDepartments.size
            val newSize = subDepartments.size
            mutableDepartmentAdapter.mutableDepartments = subDepartments
            /*
                https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.RecycledViewPool

             */
            //bindView.rcSubDepartments.recycledViewPool.clear()
            /*
                https://stackoverflow.com/questions/31759171/
                recyclerview-and-java-lang-indexoutofboundsexception-inconsistency-detected-in
             */

            mutableDepartmentAdapter.notifyItemRangeRemoved(
                0, oldSize
            )

            mutableDepartmentAdapter.notifyItemRangeInserted(
                0, newSize
            )

            postUpdate.post()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(departments: List<Department>) = DepartmentsBottomSheetDialog(departments)

        val TAG = DepartmentsBottomSheetDialog::class.java.ownTag
    }
}