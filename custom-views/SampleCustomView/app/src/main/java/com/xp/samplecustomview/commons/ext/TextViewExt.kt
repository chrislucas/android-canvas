package com.xp.samplecustomview.commons.ext

import android.widget.TextView

fun TextView.onClick(action: () -> Unit) =
    setOnClickListener { action() }