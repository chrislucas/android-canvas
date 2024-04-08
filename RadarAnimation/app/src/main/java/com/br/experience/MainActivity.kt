package com.br.experience

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.R
import com.br.experience.radaranimation.databinding.ActivityMainBinding
import com.br.openactivity.startActivityByDeeplink

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            btOpenMainComposeActivity.setOnClickListener {
                it.context.startActivityByDeeplink("dpl://main_compose_activity")
            }

            btOpenDrawingCenteredTextActivity.setOnClickListener {
                it.context.startActivityByDeeplink("dpl://drawing_centered_text")
            }

            btOpenFirstTutorialCompose.setOnClickListener {
                it.context.startActivityByDeeplink("dpl://1st_tutorial_jetpack_compose")
            }

            btOpenTutorialRoomWithViewModelAndLivedata.setOnClickListener {
                it.context.startActivityByDeeplink("dpl://codelabsroomwithviewmodelandlivedata")
            }

            btOpenTutorialRoomWithViewModelAndFlow.setOnClickListener {
                it.context.startActivityByDeeplink("dpl://codelabsroomwithviewmodelandflow")
            }

            btOpenTutorialViewModelAndLivedataTestCodelabs.setOnClickListener {
                it.context.startActivityByDeeplink("dpl://codelabsscramblewordgamecopy")
            }

            btOpenTutorialCoroutineDispatcher.setOnClickListener {
                it.context.startActivityByDeeplink("dpl://samplecoroutinedispatcher")
            }


            btOpenTutorialAccessibilityService.setOnClickListener {
                it.context.startActivityByDeeplink("dpl://samplecheckcontentdescriptionintext")
            }
        }
    }
}