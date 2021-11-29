package com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.models.MenuOption
import com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.list.viewholder.ListOptionsViewHolder

class ListOptionsAdapter(private val options: List<MenuOption>) :
    RecyclerView.Adapter<ListOptionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOptionsViewHolder {
        return ListOptionsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item_menu_option_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListOptionsViewHolder, position: Int) {
        with(options[position]) {
            holder.optionRadioButton.text = this.label

            holder.optionRadioButton.setOnClickListener {
                this.action()
            }
        }
    }

    override fun getItemCount(): Int = options.size
}