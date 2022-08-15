package com.xp.samplecustomview.feature.galleryoffeatures.models

import com.xp.samplecustomview.feature.recyclerview.samples.deparments.feature.multilevel.view.fragments.TreeStructureDepartmentsBottomSheetDialogsFragment

class BindItemTreeStructureDepartmentRecyclerView(channel: ListenerListFragments) :
    BindItemFeatureDefaultForFragment(
        channel,
        TreeStructureDepartmentsBottomSheetDialogsFragment.newInstance()
    )
