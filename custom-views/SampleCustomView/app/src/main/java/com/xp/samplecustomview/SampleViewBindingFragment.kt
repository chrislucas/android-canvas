package com.xp.samplecustomview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.xp.samplecustomview.databinding.FragmentSampleViewBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SampleViewBindingFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 * Lembrete: Fragments precisam ter construtores publicos
 *
 */
class SampleViewBindingFragment public constructor() : BaseFragment() {

    private lateinit var binding: FragmentSampleViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSampleViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        // Segundo a documentacao, se o layout possuir uma configuracao onde
        // o id do elemento nao for definido, esse elemento eh Nullable
        // fonte : https://developer.android.com/topic/libraries/view-binding
        binding.buttonBlankFragment?.setOnClickListener {
            Toast.makeText(
                context
                , "Simples teste do ViewBinding"
                , Toast.LENGTH_SHORT
            ).show()
        }
    }


    override fun getTag1() = javaClass.name

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment SampleViewBindingFragment.
         */
        @JvmStatic
        fun newInstance() = SampleViewBindingFragment()
    }
}
