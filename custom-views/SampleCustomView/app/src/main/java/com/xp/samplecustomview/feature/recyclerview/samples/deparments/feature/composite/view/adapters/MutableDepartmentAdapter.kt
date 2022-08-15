package com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.composite.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.Department
import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.composite.view.holder.DepartmentViewHolder

class MutableDepartmentAdapter(var mutableDepartments: List<Department>) :
    RecyclerView.Adapter<DepartmentViewHolder>(), PostUpdateCombinedRecyclerView {

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_item_departments, parent,
            false
        )
        return DepartmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        mutableDepartments[holder.absoluteAdapterPosition].run {
            holder.departmentName.text = this.name
            holder.departmentImage.setImageResource(R.drawable.ic_baseline_cloud_upload_24)
        }
        lastPosition = holder.absoluteAdapterPosition
    }

    override fun post() {
        lastPosition = -1
    }

    override fun getItemCount(): Int = mutableDepartments.size
}