package com.xp.samplecustomview.commons.ext

import android.content.Context
import android.os.IBinder
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Context.closeKeyBoard(iBinder: IBinder, flag: Int) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(iBinder, flag)
}

fun View.openKeyBoard(flag: Int) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, flag)
}
