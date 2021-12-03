package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models

interface MetadataListItem {
    fun getDescription(): String
}

interface CompositeListItem : MetadataListItem {
    fun apply()
}