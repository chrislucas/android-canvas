package com.xp.samplecustomview.feature.customviews.sample.canvas.feature.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xp.samplecustomview.R

class BoardToDrawVerticesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_board_to_draw_vertices, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BoardToDrawVerticesFragment()
    }
}