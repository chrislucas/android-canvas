package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models

interface ComposeSection {
    fun getLabel(): String
    fun getSubSection(): List<ComposeSection>
}