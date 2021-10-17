package com.xp.samplecustomview.feature.webview.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationFragmentActivity

/**
 *
 * https://developer.android.com/guide/webapps/webview
 * https://developer.android.com/guide/webapps/webview#BindingJavaScript
 * */

class SimpleWebViewFragment : Fragment(), BaseBehaviorFragment {

    private lateinit var channelCommunicationFragmentActivity: ChannelCommunicationFragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_web_view, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChannelCommunicationFragmentActivity) {
            channelCommunicationFragmentActivity = context
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SimpleWebViewFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}