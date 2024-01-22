package com.br.experience.features.codelabs.arch.basicroomwithllivedata

import android.content.Context
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AppUtils private constructor(context: Context) {

    val coroutineScope = CoroutineScope(SupervisorJob())

    // val database by lazy { WordDB.getInstance(context, coroutineScope) }
    val repository by lazy { WordRepository(context, coroutineScope) }



    companion object {
        @Volatile
        private var appUtils: AppUtils? = null

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