package com.br.androidcanvas.chp4

import android.graphics.Typeface

/**
 * @see Typeface - setSystemFontMap
 */
private val fontsFamily = arrayOf(
    "serif", "sans-serif", "cursive", "fantasy", "monospace", "system-ui"
)

private val typefaces =
    arrayOf(Typeface.ITALIC, Typeface.BOLD_ITALIC, Typeface.NORMAL, Typeface.BOLD)

val mapTypefaces: Map<Int, String> = mutableMapOf(
    Typeface.ITALIC to "Typeface.ITALIC",
    Typeface.BOLD_ITALIC to "Typeface.BOLD_ITALIC",
    Typeface.NORMAL to "Typeface.NORMAL",
    Typeface.BOLD to "Typeface.BOLD",
)


val mapFontAndTypefaces: MutableMap<String, List<Typeface>> = mutableMapOf()
    get() {
        for (fontFamily in fontsFamily) {
            field[fontFamily] = typefaces.map { Typeface.create(fontFamily, it) }
        }
        return field
    }

