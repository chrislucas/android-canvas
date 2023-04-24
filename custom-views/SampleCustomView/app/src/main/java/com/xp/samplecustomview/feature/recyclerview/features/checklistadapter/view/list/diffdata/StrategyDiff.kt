package com.xp.samplecustomview.feature.recyclerview.features.checklistadapter.view.list.diffdata

import androidx.recyclerview.widget.DiffUtil

fun <T> providerDiffCallback(comparator: Comparator<T>) = object : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        comparator.compare(oldItem, newItem) == 0


    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        comparator.compare(oldItem, newItem) == 0
}