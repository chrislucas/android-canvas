package com.br.experience.features.codelabs.arch.basicroomwithllivedata.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.experience.features.codelabs.arch.AppUtils
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.model.Word
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.viewmodel.WordViewModel
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.views.adapter.WordListAdapter
import com.br.experience.radaranimation.databinding.ActivityCodelabsRoomWithViewmodelAndLivedataBinding

/**
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=pt-br#0
 * https://github.com/android/codelab-android-room-with-a-view/tree/kotlin
 *
 * O codigo do github está mais atualiizado
 * https://github.com/android/codelab-android-room-with-a-view/blob/kotlin/app/src/main/java/com/example/android/roomwordssample/WordViewModel.kt
 *
 * TODO
 * ler esse artigo
 * https://developer.android.com/training/data-storage/room
 *
 * 7 Pro-tips for Room
 * https://medium.com/androiddevelopers/7-pro-tips-for-room-fbadea4bfbd1
 *
 * Incrementally migrate from SQLite to Room
 * https://medium.com/androiddevelopers/incrementally-migrate-from-sqlite-to-room-66c2f655b377
 */
class CodeLabsRoomWithViewModelAndLiveData : AppCompatActivity() {

    private val binder: ActivityCodelabsRoomWithViewmodelAndLivedataBinding by lazy {
        ActivityCodelabsRoomWithViewmodelAndLivedataBinding.inflate(layoutInflater)
    }

    /**
     * @see viewModels
     */

    private val viewModel: WordViewModel by viewModels {
        AppUtils.getInstance(this)?.wordLiveDataRepository?.let { repo -> WordViewModel.WordViewModelFactory(repo) }
            ?: throw Exception("Was not possible to create WordViewModel")
    }

    private val adapter: WordListAdapter by lazy { WordListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binder.root)
        bindViews()
        viewModel.wordsLiveData.observe(this) { words ->
            adapter.submitList(words)
        }
    }

    private fun bindViews() {
        with(binder.recyclerviewWordList) {
            adapter = this@CodeLabsRoomWithViewModelAndLiveData.adapter
            layoutManager = LinearLayoutManager(context)
        }
        binder.fbAddWord.setOnClickListener {
            binder.tvEditWord.text.let {
                if (!it.isNullOrEmpty()) {
                    viewModel.insert(Word(it.toString()))
                } else {
                    Toast.makeText(
                        this@CodeLabsRoomWithViewModelAndLiveData,
                        "Caixa de Texto Vazia !", Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}