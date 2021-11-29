package com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.list.viewholder

import android.view.View
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

class ListOptionsViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {

    val optionRadioButton: RadioButton = itemView.findViewById(R.id.rb_item_option)

}