package com.br.experience.features.codelabs.arch.basicroomwithflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.experience.features.codelabs.arch.AppUtils
import com.br.experience.features.codelabs.arch.basicroomwithflow.model.Word
import com.br.experience.features.codelabs.arch.basicroomwithflow.viewmodel.WordFlowViewModel
import com.br.experience.features.codelabs.arch.basicroomwithflow.views.adapter.FlowWordListAdapter
import com.br.experience.radaranimation.databinding.ActivityCodelabsRoomWithViewmodelAndFlowBinding

/**
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=pt-br#0
 * https://github.com/android/codelab-android-room-with-a-view/tree/kotlin
 *
 * Fazer o mesmo exemplo usando Flow ao inves de view model
 */

class CodeLabsRoomWithViewModelAndFlow : AppCompatActivity() {

    private val binder: ActivityCodelabsRoomWithViewmodelAndFlowBinding by lazy {
        ActivityCodelabsRoomWithViewmodelAndFlowBinding.inflate(layoutInflater)
    }

    private val adapter: FlowWordListAdapter by lazy { FlowWordListAdapter() }

    private val viewModel: WordFlowViewModel by viewModels {
        AppUtils.getInstance(this)?.wordFlowRepository?.let { repository ->
            WordFlowViewModel.WordFlowViewModelFactory(repository)
        } ?: throw Exception("Was not possible to create WordFlowViewModel")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binder.root)
        bindViews()
        viewModel.words.observe(this) { words ->
            adapter.submitList(words)
        }
    }

    private fun bindViews() {

        with(binder) {
            rcWorldlistV2.run {
                adapter = this@CodeLabsRoomWithViewModelAndFlow.adapter
                layoutManager = LinearLayoutManager(context)
            }

            fbAddWordV2.setOnClickListener {
                etWordV2.text.let { text ->
                    if (!text.isNullOrEmpty()) {
                        viewModel.insert(Word(text.toString()))
                    } else {
                        Toast.makeText(
                            this@CodeLabsRoomWithViewModelAndFlow,
                            "Caixa de texto vazia",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}