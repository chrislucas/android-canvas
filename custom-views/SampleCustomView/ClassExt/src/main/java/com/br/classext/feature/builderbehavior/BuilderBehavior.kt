package com.br.classext.feature.builderbehavior

//  Representa um contrato aberto para qualquer comportamento
interface Behavior

interface BuilderBehavior {
    fun build(): Behavior
}

fun String.fromClassNameToCreateBehavior(): Behavior? {
    return try {
        val builder = Class.forName(this).getConstructor().newInstance()
        if (builder is BuilderBehavior) {
            builder.build()
        } else {
            null
        }
    } catch (c: ClassNotFoundException) {
        null
    }
}