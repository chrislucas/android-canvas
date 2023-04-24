package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.view.viewholders.DepartmentViewHolder
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.Department

/*
    TODO adicioanr titulo a todas as RecyclerViews
    Usar a classe Section para que cada Sescao
 */

class HorizontalDepartmentAdapter(
    private val departments: List<Department>,
    private val onClickDepartment: OnClickDepartment
) : RecyclerView.Adapter<DepartmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        return DepartmentViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        if (departments.isNotEmpty()) {
            departments[position].let { department ->
                holder.departmentName.text = department.description
                holder.departmentImage.setImageResource(R.drawable.ic_baseline_cloud_upload_24)
                holder.itemView.setOnClickListener {
                    onClickDepartment.onClick(department)
                }
            }
        }
    }

    override fun getItemCount(): Int = departments.size

    interface OnClickDepartment {
        fun onClick(department: Department)
    }
}


