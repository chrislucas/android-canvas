package com.br.experience.features.tutorials.medium.aboutcoroutines.dispatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.br.experience.radaranimation.R
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

/**
 * Esse artigo instigou a curiosidade sobre dispachers
 * https://medium.com/mobile-app-development-publication/7-gotchas-when-explore-kotlin-coroutine-64b78f005150
 */

class SampleCoroutineDispatcherKDocActivity : AppCompatActivity() {

    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_coroutine_dispatcher_kdoc)

        launchCoroutineTest()
        launchCoroutineTest(Dispatchers.Unconfined)
        launchCoroutineTest(Dispatchers.Default)
        launchCoroutineTest(Dispatchers.IO)
        launchCoroutineTest(newSingleThreadContext("MyOwnThread"))
    }

    private fun launchCoroutineTest(coroutineScope: CoroutineContext = EmptyCoroutineContext) {
        /**
         * Coroutine context and dispatchers
         * https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html
         */
        CoroutineScope(coroutineScope).launch {
            if (Log.isLoggable("LOG_COROUTINE", Log.INFO)) {
                Log.i(
                    "LOG_COROUTINE",
                    "main runBlocking: I'm working in thread ${Thread.currentThread().name}"
                )
            }
        }
    }
}