package com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.reyclerview.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.xp.samplecustomview.R

class FeatureCustomViews(viewRoot: View): RecyclerView.ViewHolder(viewRoot) {
    val tvTitle: MaterialTextView = viewRoot.findViewById(R.id.tv_title_feature_custom_view)
}