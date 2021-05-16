package com.xp.samplecustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.xp.samplecustomview.feature.galleryoffeatures.view.fragments.FragmentGalleryOfFeatures
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment
import com.xp.samplecustomview.helper.fragments.CommunicationChannelFragmentActivity

class MainActivity : AppCompatActivity(), CommunicationChannelFragmentActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        load(FragmentGalleryOfFeatures.newInstance())
        log()
    }

    // https://medium.com/@mbonnin/the-different-kotlin-stdlibs-explained-83d7c6bf293
    private fun log() {
        Log.i(
            "SYSTEM_PROPERTY",
            "java.specification.version:${System.getProperty("java.specification.version") ?: ":null"}"
        )
        Log.i("SYSTEM_PROPERTY", "java.vm.name:${System.getProperty("java.vm.name") ?: "null"}")
    }


    private fun load(fragmentBase: BaseBehaviorFragment) {

        supportFragmentManager.let {
            manager ->
            if (manager.backStackEntryCount > 1)
                manager.popBackStack()

            if (manager.findFragmentByTag(fragmentBase.getMyOwnTag()) == null) {
                manager.beginTransaction()
                    .replace(
                        R.id.layout_replace,
                        fragmentBase.getInstanceFragment(),
                        fragmentBase.getMyOwnTag()
                    )
                    .commit()
            }
        }


    }

    override fun openThisFragment(baseBehaviorFragment: BaseBehaviorFragment) {
        load(baseBehaviorFragment)
    }

}
