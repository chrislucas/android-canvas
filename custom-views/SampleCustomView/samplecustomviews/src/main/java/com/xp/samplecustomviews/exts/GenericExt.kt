package com.xp.samplecustomviews.exts

fun <T, R> T?.runOrElse(block: T.() -> R, defaultFun: () -> R ) : R {
    return this?.run(block) ?: defaultFun()
}