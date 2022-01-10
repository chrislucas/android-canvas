package com.xp.samplecustomview.feature.customviews.sample

import com.xp.samplecustomview.feature.customviews.sample.behaviorcustomview.view.fragment.AttachBehaviorOnCustomViewByXmlLayout
import com.xp.samplecustomview.feature.customviews.sample.canvasbook.chp1.view.fragment.ShowCustomSimpleViewFragment
import com.xp.samplecustomview.feature.customviews.sample.canvasbook.customviews.view.fragment.DrawingDotsFragment
import com.xp.samplecustomview.feature.customviews.sample.canvasbook.customviews.view.fragment.MovingInCircleCustomViewFragment
import com.xp.samplecustomview.feature.customviews.sample.canvasbook.customviews.view.fragment.ShowCircleViewFragment
import com.xp.samplecustomview.feature.customviews.sample.dashedprogressbar.view.fragment.CustomDashedProgressBarFragment
import com.xp.samplecustomview.feature.customviews.sample.popupview.view.fragment.CustomPopupViewFragment

val listOfFragments = listOf(
    CustomDashedProgressBarFragment.newInstance(),
    CustomPopupViewFragment.newInstance(),
    ShowCustomSimpleViewFragment.newInstance(),
    AttachBehaviorOnCustomViewByXmlLayout.newInstance(),
    MovingInCircleCustomViewFragment.newInstance(),
    ShowCircleViewFragment.newInstance(),
    DrawingDotsFragment.newInstance()
)