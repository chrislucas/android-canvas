package com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.viewholders.DepartmentViewHolder
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.Department

class HorizontalDepartmentAdapter(private val departments: List<Department>) :
    RecyclerView.Adapter<DepartmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        return DepartmentViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        if (departments.isNotEmpty()) {
            departments[position].let {
                department ->
                holder.departmentName.text = department.name
                holder.departmentImage.setImageResource(R.drawable.ic_baseline_cloud_upload_24)
                holder.itemView.setOnClickListener {}
            }
        }
    }

    override fun getItemCount(): Int = departments.size
}