package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.view.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

class DepartmentViewHolder private constructor(rootView: View): RecyclerView.ViewHolder(rootView) {

    val departmentImage: ImageView = itemView.findViewById(R.id.im_icon_department)
    val departmentName: TextView = itemView.findViewById(R.id.tv_title_department)

    companion object {
        @JvmStatic
        fun newInstance(viewGroup: ViewGroup) : DepartmentViewHolder {
            val view = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.layout_item_departments, viewGroup,
                false)
            return DepartmentViewHolder(view)
        }
    }
}