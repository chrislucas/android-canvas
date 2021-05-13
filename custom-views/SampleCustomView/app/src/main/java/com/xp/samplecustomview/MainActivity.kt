package com.xp.samplecustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(SampleViewBindingFragment.newInstance())
        log()
    }

    // https://medium.com/@mbonnin/the-different-kotlin-stdlibs-explained-83d7c6bf293
    private fun log() {
        Log.i("SYSTEM_PROPERTY", "java.specification.version:${System.getProperty("java.specification.version") ?: ":null"}")
        Log.i("SYSTEM_PROPERTY", "java.vm.name:${System.getProperty("java.vm.name") ?: "null"}")
    }


    private fun loadFragment(fragment: BaseFragment) {
        if (supportFragmentManager.findFragmentByTag(fragment.getTag1()) == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.layout_replace,
                    fragment,
                    fragment.getTag1()
                )
                .commit()
        }
    }
}
