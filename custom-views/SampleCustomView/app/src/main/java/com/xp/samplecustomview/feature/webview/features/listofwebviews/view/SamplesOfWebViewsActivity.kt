package com.xp.samplecustomview.feature.webview.features.listofwebviews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.view.recyclerview.action.DefaultSimpleBindViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.adapter.GenRecyclerView
import com.xp.samplecustomview.databinding.ActivitySamplesOfWebviewsBinding
import com.xp.samplecustomview.feature.galleryoffeatures.models.CompositeRecyclerViewItem
import com.xp.samplecustomview.feature.webview.features.listofwebviews.model.provideWebViewSamples

class SamplesOfWebViewsActivity : AppCompatActivity() {

    private val bind: ActivitySamplesOfWebviewsBinding by lazy {
        ActivitySamplesOfWebviewsBinding.inflate(layoutInflater)
    }

    private val webViewSamples : MutableList<CompositeRecyclerViewItem<Any>> by lazy {
        provideWebViewSamples().toMutableList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_samples_of_webviews)

        with(bind.rcWebViewSamples) {
            adapter = GenRecyclerView(
                webViewSamples,
                DefaultSimpleBindViewHolder()
            )
        }
    }
}