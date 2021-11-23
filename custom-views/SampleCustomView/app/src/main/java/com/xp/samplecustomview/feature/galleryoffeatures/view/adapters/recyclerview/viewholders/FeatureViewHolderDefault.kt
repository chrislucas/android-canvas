package com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

class FeatureViewHolderDefault(layoutView: View): RecyclerView.ViewHolder(layoutView) {
    val viewIcon: ImageView by lazy { layoutView.findViewById(R.id.iv_icon) }
    val viewTitle: TextView by lazy { layoutView.findViewById(R.id.tv_title) }
}