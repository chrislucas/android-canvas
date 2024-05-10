package com.br.funwithhandler

import android.os.Handler
import android.os.Message


class LooperThread(name: String, private val callback: CallbackHandler): Thread(name) {


    interface CallbackHandler {
        fun call(message: Message, handler: Handler)
    }

    override fun run() {
        super.run()
    }
}


