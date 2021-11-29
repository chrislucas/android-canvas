package com.xp.samplecustomview.feature.bottomsheet.modalbottomsheet.listoption.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

class SimpleBottomSheetDialog: BottomSheetDialogFragment(), BaseBehaviorFragment {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}
}