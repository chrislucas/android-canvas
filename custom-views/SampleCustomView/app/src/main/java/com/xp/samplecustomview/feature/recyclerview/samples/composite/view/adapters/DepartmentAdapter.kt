package com.xp.samplecustomview.feature.recyclerview.samples.composite.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.feature.recyclerview.samples.composite.models.Department
import com.xp.samplecustomview.feature.recyclerview.samples.composite.view.holder.DepartmentViewHolder

open class DepartmentAdapter(
    private val departments: List<Department>,
    private val updateCombinedRecyclerVew: UpdateCombinedRecyclerVew
) :
    RecyclerView.Adapter<DepartmentViewHolder>() {

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_item_departments, parent,
            false
        )
        return DepartmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        val pos = holder.bindingAdapterPosition
        departments[pos].run {
            holder.departmentName.text = this.description
            holder.departmentImage.setImageResource(R.drawable.ic_baseline_cloud_upload_24)
            parent?.let {
                updateCombinedRecyclerVew.update(it)
            }
            lastPosition = pos
        }
    }

    override fun getItemCount(): Int = departments.size
}

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
        mutableDepartments[position].run {
            holder.departmentName.text = this.description
            holder.departmentImage.setImageResource(R.drawable.ic_baseline_cloud_upload_24)
        }
        lastPosition = position
    }

    override fun post() {
        lastPosition = -1
    }

    override fun getItemCount(): Int = mutableDepartments.size
}