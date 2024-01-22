package com.br.experience.features.codelabs.arch.basicroomwithflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.R
import com.br.experience.radaranimation.databinding.ActivityCodelabsRoomWithViewmodelAndFlowBinding

/**
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=pt-br#0
 * https://github.com/android/codelab-android-room-with-a-view/tree/kotlin
 *
 * Fazer o mesmo exemplo usando Flow ao inves de view model
 */

class CodeLabsRoomWithViewModelAndFlow : AppCompatActivity() {

    val binder: ActivityCodelabsRoomWithViewmodelAndFlowBinding by lazy {
        ActivityCodelabsRoomWithViewmodelAndFlowBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codelabs_room_with_viewmodel_and_flow)
    }
}