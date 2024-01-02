package com.br.experience.features.cardview.layoutbasedcardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.experience.radaranimation.R

/**
 * https://developer.android.com/guide/topics/ui/layout/cardview?hl=pt-br
 *
 * Read
 * https://developer.android.com/develop/ui/views/layout/cardview
 *
 * Read - Compose
 * https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#Card(androidx.compose.ui.Modifier,androidx.compose.ui.graphics.Shape,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.foundation.BorderStroke,androidx.compose.ui.unit.Dp,kotlin.Function0)
 */
class LayoutBasedOnCardViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_based_on_card_view)
    }
}