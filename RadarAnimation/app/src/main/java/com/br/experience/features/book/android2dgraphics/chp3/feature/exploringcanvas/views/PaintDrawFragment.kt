package com.br.experience.features.book.android2dgraphics.chp3.feature.exploringcanvas.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.experience.radaranimation.R

class PaintDrawFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paint_draw, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            PaintDrawFragment()
    }
}