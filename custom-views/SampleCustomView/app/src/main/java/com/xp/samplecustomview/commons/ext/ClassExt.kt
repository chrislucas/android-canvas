package com.xp.samplecustomview.commons.ext

val <T> Class<T>.ownTag : String
        get() = "TAG[${simpleName}]"


