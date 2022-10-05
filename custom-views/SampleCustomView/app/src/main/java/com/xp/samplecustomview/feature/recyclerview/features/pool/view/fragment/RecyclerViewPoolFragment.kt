package com.xp.samplecustomview.feature.recyclerview.features.pool.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R

/*
    https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.RecycledViewPool
    https://gist.github.com/yrom/728237025575005a8fd3
    https://medium.com/@thagikura/reduce-the-number-of-inflation-of-viewholders-drastically-by-sharing-a-viewpool-across-multiple-249d5fc6d28
    https://androidexplained.github.io/android/ui/2020/11/09/recycler-view-optimization-pool.html
 */

class MyRecyclerViewPool : RecyclerView.RecycledViewPool() {

}

class RecyclerViewPoolFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view_pool, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RecyclerViewPoolFragment()
    }
}