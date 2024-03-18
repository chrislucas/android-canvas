package com.br.experience.features.codelabs.arch

import android.content.Context
import com.br.experience.features.codelabs.arch.basicroomwithflow.repository.WordFlowRepository
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.repository.WordLiveDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AppUtils private constructor(context: Context) {

    val coroutineScope = CoroutineScope(SupervisorJob())

    // val database by lazy { WordDB.getInstance(context, coroutineScope) }
    val wordLiveDataRepository by lazy { WordLiveDataRepository(context, coroutineScope) }

    val wordFlowRepository by lazy { WordFlowRepository(context, coroutineScope) }

    companion object {
        @Volatile
        private var appUtils: AppUtils? = null

        @JvmStatic
        fun getInstance(ctx: Context): AppUtils? {
            return if (appUtils == null) {
                synchronized(AppUtils::class.java) {
                    appUtils = AppUtils(ctx)
                }
                appUtils
            } else {
                appUtils
            }
        }
    }
}