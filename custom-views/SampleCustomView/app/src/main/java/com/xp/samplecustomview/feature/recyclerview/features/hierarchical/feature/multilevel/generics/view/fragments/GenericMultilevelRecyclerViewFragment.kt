package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.R


/**
 * TODO escreer um exemplo Usando os modelos Genericos de como montar construir
 * uma recyclerview de multinivel
 *
 * @see MultiLevelRecyclerViewAdapter
 * @see Selector
 */
class GenericMultilevelRecyclerViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_generic_multilevel_recycler_view,
            container,
            false
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = GenericMultilevelRecyclerViewFragment()
    }
}