package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models.helper

import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models.CompositeWrapper

fun <T> parse(compositeWrapper: CompositeWrapper<T>) {

    fun builder(compositeWrapper: CompositeWrapper<T>) {
        for (data in compositeWrapper.composition) {

        }
    }

    builder(compositeWrapper)

}