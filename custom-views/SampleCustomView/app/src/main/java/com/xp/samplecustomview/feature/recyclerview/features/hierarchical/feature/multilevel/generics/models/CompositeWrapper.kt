package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models


/*
    Representa uma seção ou linha da reyclerview de recycelrviews
 */

data class CompositeWrapper<T>(
    val subSectionName: String = "undefined section name",
    val data: T? = null,
    val composition: List<CompositeWrapper<T>> = emptyList()
)