package com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.composite.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.sample.providerDepartments
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.composite.view.bottomsheet.departments.DepartmentsBottomSheetDialog
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

class TwoListDepartmentBottomSheetDialogFragment : Fragment(), BaseBehaviorFragment {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        activity?.supportFragmentManager?.let {
            fm ->
            val dialog = DepartmentsBottomSheetDialog.newInstance(providerDepartments())
            dialog.show(fm, DepartmentsBottomSheetDialog.TAG)
        }

        return inflater.inflate(
            R.layout.fragment_two_list_department_bottom_sheet_dialog,
            container,
            false
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = TwoListDepartmentBottomSheetDialogFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}