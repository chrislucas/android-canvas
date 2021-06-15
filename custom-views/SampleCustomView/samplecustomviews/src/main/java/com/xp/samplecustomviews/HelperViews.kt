package com.xp.samplecustomviews

import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.min

fun AttributeSet.log(tag: String) {
    Log.i(tag, "Count ${this.attributeCount}")
}

fun View.log(message: String, tag: String = "View's Lifecycle") {
    val className = javaClass.name
    Log.i("$tag - $className".substring(0, min(className.length, 22)), message)
}