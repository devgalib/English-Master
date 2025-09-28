package com.edureminder.english.screen.challenges_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TextToImageSelectQuiz(
    modifier: Modifier = Modifier
) {
    var isSelected by remember { mutableStateOf(false) }
    val options = listOf("বাবা", "মা", "পরিবার", "ভাই")
    Column (
        modifier = modifier
            .widthIn(max = 350.dp)
            .padding(start = 15.dp, end = 10.dp, top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
    ) {
        Text(
            text = "নিচের শব্দটির বাংলা কোনটি?",
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Family",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        FlowRow (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            maxItemsInEachRow = 2
        ) {
            options.forEachIndexed { index, option ->
                SelectTextButton(
                    Modifier
                        .weight(1f),
                    option,
                    isSelected,
                    onClick = {
                        isSelected = !isSelected
                    }
                )
            }
        }
    }
}

