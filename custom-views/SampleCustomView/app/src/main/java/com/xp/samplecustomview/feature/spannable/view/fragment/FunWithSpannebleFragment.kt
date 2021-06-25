package com.xp.samplecustomview.feature.spannable.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.R

// https://developer.android.com/reference/android/text/style/ImageSpan


class FunWithSpannebleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fun_with_spanneble, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FunWithSpannebleFragment()
    }
}