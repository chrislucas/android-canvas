package com.xp.samplecustomview.commons.view.recyclerview.action

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.commons.view.recyclerview.viewholder.helper.BuilderViewHolder

class DefaultSimpleBindViewHolder : SimpleBindViewHolder {
    override fun getViewHolder(viewType: Int, viewRoot: ViewGroup): RecyclerView.ViewHolder =
        BuilderViewHolder.build(viewType, viewRoot)
}
