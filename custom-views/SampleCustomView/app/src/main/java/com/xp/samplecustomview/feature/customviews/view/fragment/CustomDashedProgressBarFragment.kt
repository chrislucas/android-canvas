package com.xp.samplecustomview.feature.customviews.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment


class CustomDashedProgressBarFragment : Fragment(), BaseBehaviorFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_dashed_progress_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvPercentage: TextView = view.findViewById(R.id.tv_percentage)
        view.findViewById<ProgressBar>(R.id.progressbar).let { progressBar ->
            Thread {
                updateProgressBar(progressBar, tvPercentage)
            }.start()
        }
    }


    /**
     * TODO mudar essa implementacao para uma ViewModel com coroutines
     * A ViewModel deve ser responsável por alterar o estado do Progressbar
     * e do texto de porcentagem dela
     * */
    private fun updateProgressBar(progressBar: ProgressBar, tvPercentage: TextView) {
        activity?.run {
            var counter1 = 0
            var counter2 = 0
            var flag = true
            while (true) {
                flag = (counter2 / 100) and 1 == 0
                if (flag)
                    counter1 += 1
                else
                    counter1 -= 1
                this.runOnUiThread {
                    progressBar.progress = counter1
                }
                Thread.sleep(100)
                counter2 += 1
                counter2 %= 1000

                tvPercentage.text = String.format("%d%%", counter1)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CustomDashedProgressBarFragment()
    }

    override fun getMyOwnTag(): String = javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}