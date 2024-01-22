package com.br.experience.features.utils.view

import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

object ViewModelBuilder {

    @JvmStatic
    fun <V : ViewModel> build(
        viewModelStore: ViewModelStore,
        factory: ViewModelProvider.Factory,
        clazz: Class<V>
    ): V = ViewModelProvider(viewModelStore, factory)[clazz]
}

abstract class BaseViewModel(
    private val supervisorJob: CompletableJob = SupervisorJob(),
    override val coroutineContext: CoroutineContext = Dispatchers.Main + supervisorJob
) : ViewModel(), CoroutineScope {
    override fun onCleared() {
        super.onCleared()
        supervisorJob.cancelChildren()
    }
}

class ViewModelFactory(private val argsAndValues: Map<Class<*>, List<*>> = emptyMap()) : ViewModelProvider.Factory {

    constructor(arg: Class<*>, value: Any) : this(mapOf(arg to listOf(value)))

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (argsAndValues.isEmpty()) {
            modelClass.getConstructor().newInstance()
        } else {
            val arguments: Array<Class<*>> = argsAndValues.keys.toTypedArray()
            val argumentsOfArgument: List<List<*>> = argsAndValues.values.toList()
            when (argumentsOfArgument.size) {
                1 -> {
                    if (argumentsOfArgument[0].isEmpty()) {
                        modelClass.getConstructor().newInstance()
                    } else {
                        modelClass.getConstructor(*arguments).newInstance(argumentsOfArgument[0][0])
                    }
                }

                else -> {
                    modelClass.getConstructor(*arguments).newInstance(argumentsOfArgument)
                }
            }
        }
    }
}

fun FragmentActivity.getHeightStatusBar(): Int {
    val rect = Rect()
    window.decorView.getWindowVisibleDisplayFrame(rect)
    return window.findViewById<View?>(Window.ID_ANDROID_CONTENT).top - rect.top

}

/**
 * https://developer.android.com/training/system-ui/immersive?hl=pt-br
 */

fun FragmentActivity.hideSystemUI() {
    // Enables regular immersive mode.
    // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
    // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
            // Set the content to appear under the system bars so that the
            // content doesn't resize when the system bars hide and show.
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            // Hide the nav bar and status bar
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_FULLSCREEN)
}


fun FragmentActivity.showSystemUI() {
    window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
}