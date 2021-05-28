package com.xp.samplecustomview.helper.fragments

import androidx.fragment.app.Fragment


interface BaseBehaviorFragment {
    fun getMyOwnTag() : String
    fun getInstanceFragment(): Fragment
    fun actionOnBackPressedInFragment()
}
