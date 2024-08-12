package com.br.experience.features.memoryleak

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.br.experience.radaranimation.R
import com.br.experience.radaranimation.databinding.ActivityCheckMemoryLeakBinding

/**
 * https://medium.com/@naeem0313/top-10-android-memory-leak-causes-and-how-to-avoid-them-b7ea67e716b6
 *
 * TODO ler tambem
 * vhttps://medium.com/android-development-hub/understanding-and-preventing-memory-leaks-in-android-a-comprehensive-guide-75ad5751aa3c
 *
 * Inspect your app's memory usage with Memory Profiler
 * https://developer.android.com/studio/profile/memory-profiler
 */
class CheckMemoryLeakActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCheckMemoryLeakBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckMemoryLeakBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_check_memory_leak)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }

    private val handler = Handler(Looper.getMainLooper())

    /**
     * Essa InnerClass aqui deve gerar uma memoru leak
     */
    private val updateRunnable = Runnable {
        Log.i("HANDLER_MEMORY_LEAK", "it's me")
        /**
         * Um bom teste, usar o handler para executar esse runnable com postDelayed
         * com bastante atraso e destruir a activity antes do handler postar o runnable
         * para ver o memory leak
         */
        binding.fab.performClick()
    }

    private fun caseHandlerAsInnerClassOfActivityOrFragment() {
        /**
         * https://medium.com/@naeem0313/top-10-android-memory-leak-causes-and-how-to-avoid-them-b7ea67e716b6
         */

        handler.post(updateRunnable)
    }


    private fun longDelayedHandlerPostRunnableAndActivityIsDestroyed() {
        /**
         * Postar um runnnable com delay long pode ser perigoso. Se a activity for destruida
         * pode gerar um memory leak
         */


        handler.postDelayed(updateRunnable, 3000L)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_check_memory_leak)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}