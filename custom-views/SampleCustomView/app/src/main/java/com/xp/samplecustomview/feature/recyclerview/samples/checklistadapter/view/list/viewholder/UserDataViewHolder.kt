package com.xp.samplecustomview.feature.recyclerview.samples.checklistadapter.view.list.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

class UserDataViewHolder(layoutView: View) : RecyclerView.ViewHolder(layoutView) {
    val view: TextView by lazy { layoutView.findViewById(R.id.tv_title) }
}