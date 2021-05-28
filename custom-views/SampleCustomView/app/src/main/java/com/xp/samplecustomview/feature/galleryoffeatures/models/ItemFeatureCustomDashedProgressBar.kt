package com.xp.samplecustomview.feature.galleryoffeatures.models

import com.xp.samplecustomview.feature.customviews.view.fragment.CustomDashedProgressBarFragment
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationViewHolderFragment


class BindItemFeatureCustomDashedProgressBar(channel: ChannelCommunicationViewHolderFragment) :
    BindItemFeatureDefault(channel, CustomDashedProgressBarFragment.newInstance())