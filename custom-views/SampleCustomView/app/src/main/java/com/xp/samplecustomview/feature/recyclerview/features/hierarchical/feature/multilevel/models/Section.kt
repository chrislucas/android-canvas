package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models


data class Section(
    val name: String,
    val departments: List<Department>,
    val subsection: Section
)