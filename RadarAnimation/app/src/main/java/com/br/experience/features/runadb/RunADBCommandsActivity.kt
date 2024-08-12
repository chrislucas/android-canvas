package com.br.experience.features.runadb

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.br.experience.radaranimation.R
import com.br.experience.radaranimation.databinding.ActivityRunAdbcommandsBinding
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * TODO
 * https://medium.com/huawei-developers/how-to-find-package-name-and-activity-name-of-an-application-0b6858ec4f5d
 *
 * Is it possible to execute adb commands through my android app?
 * https://stackoverflow.com/questions/13381828/is-it-possible-to-execute-adb-commands-through-my-android-app
 *
 * How can I provide a command line interface to my Android app?
 * https://stackoverflow.com/questions/67395191/how-can-i-provide-a-command-line-interface-to-my-android-app
 *
 * Call activity manager (adb shell am)
 * https://developer.android.com/tools/adb#am
 *
 * Call package manager (pm)
 * https://developer.android.com/tools/adb#pm
 *
 * Android Debug Bridge (adb)
 * https://developer.android.com/tools/adb#pm
 *
 *
 * How to Find Package Name and Activity Name of an Application?
 * https://medium.com/huawei-developers/how-to-find-package-name-and-activity-name-of-an-application-0b6858ec4f5d
 *
 * ADB - Say bye to “more than one device/emulator” error
 * https://medium.com/@theapache64/adb-say-bye-to-multi-device-error-240ba10777a2
 *
 * Adb useful commands list
 * https://gist.github.com/Pulimet/5013acf2cd5b28e55036c82c91bd56d8
 *
 * https://gist.github.com/davidnunez/1404789
 */
class RunADBCommandsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRunAdbcommandsBinding

    companion object {
        val LIST_DEVICES = "adb -s RX8N10AQ2CZ shell pm list packages -f"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRunAdbcommandsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        run()
    }


    private fun run() {
        val process = Runtime.getRuntime().exec(LIST_DEVICES)
        val bufferedReader = BufferedReader(InputStreamReader(process.inputStream))
    }


}