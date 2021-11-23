package com.xp.samplecustomview.feature.galleryoffeatures.models

import com.xp.samplecustomview.feature.customviews.sample.dashedprogressbar.view.fragment.CustomDashedProgressBarFragment
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.ListenerFeaturesViewHolder


class BindItemFeatureCustomDashedProgressBar(channel: ListenerFeaturesViewHolder) :
    BindItemFeatureDefault(channel, CustomDashedProgressBarFragment.newInstance())