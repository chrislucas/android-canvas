package br.com.xplorer.beziercurves.feature.beziercurve.pathcube.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.xplorer.beziercurves.R


class BezierCurveWithPathCubeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bezier_curve_with_path_cube, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            BezierCurveWithPathCubeFragment()
    }
}