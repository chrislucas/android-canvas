package com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.models.MenuOption
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.list.viewholder.ListOptionsViewHolder

class ListOptionsAdapter(private val options: List<MenuOption>) : RecyclerView.Adapter<ListOptionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOptionsViewHolder {
       return ListOptionsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ListOptionsViewHolder, position: Int) {}

    override fun getItemCount(): Int = options.size
}