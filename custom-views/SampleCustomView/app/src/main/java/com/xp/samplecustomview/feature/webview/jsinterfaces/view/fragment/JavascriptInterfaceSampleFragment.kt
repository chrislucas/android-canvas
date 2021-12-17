package com.xp.samplecustomview.feature.webview.jsinterfaces.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.R


/**
 * https://developer.android.com/reference/android/webkit/JavascriptInterface
 * https://www.codexpedia.com/android/javascript-interface-for-android-and-javascript-communication/
 */
class JavascriptInterfaceSampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_javascript_interface_sample,
            container,
            false
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = JavascriptInterfaceSampleFragment()
    }
}