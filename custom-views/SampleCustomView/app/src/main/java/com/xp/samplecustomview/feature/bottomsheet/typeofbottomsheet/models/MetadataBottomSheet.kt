package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models

interface MetadataBottomSheet {
    val description: String
}

interface OnClickBottomSheet : MetadataBottomSheet {
    fun run()
}