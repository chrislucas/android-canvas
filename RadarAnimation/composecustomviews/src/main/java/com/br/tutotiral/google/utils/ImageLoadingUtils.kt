package com.br.tutotiral.google.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlin.random.Random

/**
 * https://github.com/android/snippets/blob/b883fb9bca33ef91cbd8f6a5d69d4cfba80f8d4e/compose/snippets/src/main/java/com/example/compose/snippets/util/ImageLoadingSampleUtils.kt
 *
 * https://picsum.photos/
 */



fun randomSampleImageUrl(
    seed: Int = Random.nextInt(0, 100000),
    width: Int = 300,
    height: Int = 300
) = "https://picsum.photos/seed/$seed/$width/$height"



@Composable
fun rememberRandomSampleImageUrl(
    seed: Int = Random.nextInt(0, 100000),
    width: Int = 300,
    height: Int = 300
) = remember {
    randomSampleImageUrl(seed, width, height)
}