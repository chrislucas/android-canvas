package com.xp.samplecustomview.feature.galleryoffeatures.models

import com.xp.samplecustomview.feature.customviews.sample.dashedprogressbar.view.fragment.CustomDashedProgressBarFragment
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder

class BindItemFeatureCustomDashedProgressBar(channel: ListenerListFragmentsViewHolder) :
    BindItemFeatureDefaultForFragment(channel, CustomDashedProgressBarFragment.newInstance())