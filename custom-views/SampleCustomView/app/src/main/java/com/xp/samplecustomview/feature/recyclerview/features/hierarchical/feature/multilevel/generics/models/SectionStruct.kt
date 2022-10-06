package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models


/*
    Representa uma seção ou linha da reyclerview de recycelrviews
 */

data class SectionStruct<T>(val sectionName: String, val values: List<T>)