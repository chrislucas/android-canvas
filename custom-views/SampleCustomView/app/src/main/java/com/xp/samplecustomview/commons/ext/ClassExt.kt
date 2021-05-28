package com.xp.samplecustomview.commons.ext

val <T> Class<T>.ownTag: String
    get() = "TAG[${simpleName}]"


fun <T> T?.letOrElse(action: () -> Unit) {
    if (this != null) {
        action()
    }
}

