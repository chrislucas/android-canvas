package com.xp.samplecustomview.feature.recyclerview.samples.composite.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.commons.gson.fromJson
import com.xp.samplecustomview.feature.recyclerview.samples.composite.models.Department
import com.xp.samplecustomview.feature.recyclerview.samples.composite.models.sample.providerDepartments
import com.xp.samplecustomview.feature.recyclerview.samples.composite.view.bottomsheet.departments.DepartmentsBottomSheetDialog
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

class CompositeDepartmentsFragment() :
    BaseBehaviorFragment, Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val departments = providerDepartments()
            //fromJson<List<Department>>("src/main/res/raw/departments.json")
        activity?.supportFragmentManager?.let { fm ->
            val dialog = DepartmentsBottomSheetDialog.newInstance(departments)
            dialog.show(fm, DepartmentsBottomSheetDialog.TAG)
        }


        return inflater.inflate(R.layout.fragment_composite_departments, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CompositeDepartmentsFragment()
    }


    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}