package com.br.tutotiral.google.codelabs.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.br.tutotiral.google.codelabs.composebasics.ui.theme.RadarAnimationTheme

/**
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?hl=pt-br#0
 *
 * Regra para nomear funcoes composable
PRECISA ser um substantivo: DoneButton()
NÃO pode ser um verbo ou frase verbal: DrawTextField()
NÃO pode ser uma preposição nominal: TextFieldWithLink()
NÃO pode ser um adjetivo: Bright()
NÃO pode ser um advérbio: Outside()
Substantivos PODEM ter adjetivos descritivos como prefixos: RoundIcon()
 */
class SimpleCombinationTextElementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoneLayout()
        }
    }
}

@Composable
private fun DoneLayout() {
    RadarAnimationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TextInColumn(
                "Hello MF",
                "Sam",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
private fun DoneSingleText(name: String, modifier: Modifier = Modifier) {
    /*
        O tamanho da fonte precisa estar alinhado
        com o altura da linha onde ele será desenhahdo
        senão dependendo da quantidade de caracteres do texto,
        ele ficará com seus caracteres sobrepostos
     */
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontSize = 100.sp,
        lineHeight = 100.sp
    )
}

@Composable
private fun MultiplesTexts(message: String, from: String, modifier: Modifier = Modifier) {

    Text(
        text = message,
        modifier = modifier,
        fontSize = 100.sp,
        lineHeight = 100.sp
    )

    Text(
        text = from,
        fontSize = 20.sp,
        lineHeight = 40.sp  // altura de cima para baixo na vertical
    )
}

@Composable
private fun HierarchicalLayout() {
    /**
     * https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?hl=pt-br#7
     */

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = "Column 1")
        Text(text = "Column 2")
        Text(text = "Column 3")
    }

    /*
        Row {
            Text(text = "Row 1")
            Text(text = "Row 2")
            Text(text = "Row 3")
        }

        Box {
            Text(text = "Box 1")
            Text(text = "Box 2")
            Text(text = "Box 3")
        }

     */
}

@Composable
fun TextInColumn(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    // https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?hl=pt-br#8
    Column(
        //horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = message,
            modifier = modifier,
            fontSize = 100.sp,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = from,
            fontSize = 40.sp,
            lineHeight = 40.sp,
            modifier = modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Preview(
    showBackground = false,
    showSystemUi = true,
    name = "Previews"
)
@Composable
fun DoneLayoutPreview() {
    DoneLayout()
}