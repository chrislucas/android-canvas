package com.br.experience.features.codelabs.arch.basicroomwithllivedata.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.AppUtils
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.model.Word
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.viewmodel.WordViewModel
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.viewmodel.WordViewModelFactory
import com.br.experience.features.codelabs.arch.basicroomwithllivedata.views.adapter.WordListAdapter
import com.br.experience.radaranimation.R
import com.br.experience.radaranimation.databinding.ActivityCodelabsRoomWithViewmodelAndLivedataBinding

/**
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=pt-br#0
 * https://github.com/android/codelab-android-room-with-a-view/tree/kotlin
 *
 * O codigo do github está mais atualiizado
 * https://github.com/android/codelab-android-room-with-a-view/blob/kotlin/app/src/main/java/com/example/android/roomwordssample/WordViewModel.kt
 */
class CodeLabsRoomWithViewModelAndLiveData : AppCompatActivity() {

    private val binder: ActivityCodelabsRoomWithViewmodelAndLivedataBinding by lazy {
        ActivityCodelabsRoomWithViewmodelAndLivedataBinding.inflate(layoutInflater)
    }

    /**
     * @see viewModels
     */

    private val viewModel: WordViewModel by viewModels {

        AppUtils.getInstance(this)?.repository?.let { repo -> WordViewModelFactory(repo) }
            ?: throw Exception("Was not possible to create view Model")

    }

    private val adapter: WordListAdapter by lazy { WordListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * https://developer.android.com/develop/ui/views/layout/edge-to-edge-manually
         */
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContentView(R.layout.activity_codelabs_room_with_viewmodel_and_livedata)
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

        with(binder.fbAddWord) {
            setOnClickListener {
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
}