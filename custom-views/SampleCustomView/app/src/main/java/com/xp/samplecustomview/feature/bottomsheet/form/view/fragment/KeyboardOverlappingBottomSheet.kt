package com.xp.samplecustomview.feature.bottomsheet.form.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xp.samplecustomview.commons.ext.openKeyBoard
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.databinding.LayoutBottomSheetFragmentSolvingProblemJeyboardOverlappingBinding

/**
 * Testar algumas ideias de
 * 1 - corrigir o layout da bottomsheet quando o keyboard aparece na tela
 * 2 - Simular eventos para digitar conteudo numa edittext
 *
 * Ver
 * https://stackoverflow.com/questions/54364316/how-to-make-keydown-and-keyup-on-android-device
 * https://stackoverflow.com/questions/8696489/android-simulate-key-press
 *
 * BaseInputConnection
 * https://developer.android.com/reference/android/view/inputmethod/BaseInputConnection
 *
 * InputMethodManager
 * https://developer.android.com/reference/android/view/inputmethod/InputMethodManager
 *
 * Handle keyboard actions
 * https://developer.android.com/training/keyboard-input/commands
 */

class KeyboardOverlappingBottomSheetDialogFragment : BottomSheetDialogFragment() {

    lateinit var binding: LayoutBottomSheetFragmentSolvingProblemJeyboardOverlappingBinding
    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = LayoutBottomSheetFragmentSolvingProblemJeyboardOverlappingBinding
            .inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.run {
            binding.etValue.run {
                requestFocus()
                openKeyBoard(InputMethodManager.SHOW_FORCED)
                onKeyDown(KEYCODE_1, KeyEvent(ACTION_DOWN, KEYCODE_1))
                onKeyDown(KEYCODE_3, KeyEvent(ACTION_DOWN, KEYCODE_3))
                dispatchKeyEvent(KeyEvent(ACTION_DOWN, KEYCODE_ENTER))
                //onEditorAction(EditorInfo.IME_ACTION_DONE)
            }
            root
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = KeyboardOverlappingBottomSheetDialogFragment()

        @JvmStatic
        fun tag(): String = this::class.java.ownTag
    }

}