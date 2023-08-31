package com.br.gridsearch

import android.view.View
import com.br.gridsearch.models.Data

/*

 */

interface DisplayData {

    fun <C> createView(data: Data<C>): View
}