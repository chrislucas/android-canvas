package com.br.experience.features.codelabs.viewmodelunittest.scramblewordgamecopy.ui

import androidx.compose.runtime.Composable

/**
 * TODO apagar isso no futuro, foi sí uma ideia maluca
 */
data class GameActionContext(
    val onUserGuessChange: (String) -> Unit,
    val onKeyboardDone: () -> Unit,
) {
    val fn: @Composable (
        (Boolean, a: @Composable () -> Unit, b: @Composable () -> Unit) -> Unit
    ) = { flag, a, b ->
        if (flag) {
            a()
        } else {
            b()
        }
    }
}