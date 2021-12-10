package com.xp.samplecustomview.feature.customviews.sample.dashedprogressbar.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelCustomDashedProgressBar : ViewModel() {


    private val mutableProgressBarValue = MutableLiveData<Int>()
    val observableProgressBarValue: LiveData<Int> get() = mutableProgressBarValue

    private val mutableFlagShouldAddValueToProgressBar = MutableLiveData<Boolean>()
    val observableFlagShouldAddValueToProgressBar: LiveData<Boolean>
        get() = mutableFlagShouldAddValueToProgressBar

}