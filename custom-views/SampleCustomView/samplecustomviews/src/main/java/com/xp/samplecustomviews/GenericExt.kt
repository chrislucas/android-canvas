package com.xp.samplecustomviews

fun <T, R> T?.runOrElse(block: T.() -> R, defaultFun: () -> R ) : R {
    return this?.run(block) ?: defaultFun()
}