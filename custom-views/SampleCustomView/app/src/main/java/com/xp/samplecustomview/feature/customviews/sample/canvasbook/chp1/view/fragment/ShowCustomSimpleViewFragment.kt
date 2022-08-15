package com.xp.samplecustomview.feature.customviews.sample.canvasbook.chp1.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.R

/**
 * A simple [Fragment] subclass.
 * Use the [ShowCustomSimpleViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 * Classe responsavel por carregar uma simples custom view
 *
 * @see com.br.androidcanvas.chp1.SimpleView
 */
class ShowCustomSimpleViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_custom_simple_view, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ShowCustomSimpleViewFragment()
    }
}