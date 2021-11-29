package com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

class FeatureViewBindingFragmentViewHolder(viewRoot: View): RecyclerView.ViewHolder(viewRoot) {
    val tvTitle : TextView = viewRoot.findViewById(R.id.tv_title)
}