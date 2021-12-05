package com.xp.samplecustomview.feature.customviews.sample.samplesviewpager.view.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DefaultFragmentStateAdapter(fragmentActivity: FragmentActivity, private val pages: List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = pages.size

    override fun createFragment(position: Int): Fragment = pages[position]
}