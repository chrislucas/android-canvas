package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.composite.view.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

class DepartmentViewHolder(itemView: View): RecyclerView.ViewHolder(
    itemView
) {
    val departmentImage: ImageView = itemView.findViewById(R.id.im_icon_department)
    val departmentName: TextView = itemView.findViewById(R.id.tv_title_department)
}