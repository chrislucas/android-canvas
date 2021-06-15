package com.br.bookcustomview.popupview

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.LayoutRes

object BuilderCustomPopupView {

    fun create(
        context: Context,
        layoutParamsDimension: LayoutParamsDimension,
        @LayoutRes layout: Int
    ): CustomPopupView {
        return CustomPopupView(
            LayoutInflater.from(context).inflate(layout, null),
            layoutParamsDimension.w,
            layoutParamsDimension.h
        )
    }
}


data class LayoutParamsDimension(val w: Int, val h: Int)