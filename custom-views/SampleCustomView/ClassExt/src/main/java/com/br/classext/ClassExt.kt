package com.br.classext


interface Behavior

interface CreatorBehavior {
    fun create(): Behavior
}

fun String.fromClassNameToCreateBehavior(): Behavior? {
    return try {
        val creator = Class.forName(this).getConstructor().newInstance()
        if (creator is CreatorBehavior) {
            creator.create()
        } else {
            null
        }
    } catch (c: ClassNotFoundException) {
        null
    }
}