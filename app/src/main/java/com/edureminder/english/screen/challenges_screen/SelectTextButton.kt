package com.edureminder.english.screen.challenges_screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp
import com.edureminder.english.ui.theme.PrimaryColor

@Composable
fun SelectTextButton(
    modifier: Modifier = Modifier,
    option: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    var selectedColor = if (isSelected) Color.White else Color.Black
    var selectedBackground = if (isSelected) PrimaryColor else Color.White
    var selectedShadow = if (isSelected) PrimaryColor else Color.Gray

    Box(
        modifier = modifier
            .height(50.dp)
            .clip(CircleShape)
            .background(selectedShadow)
            .background(Color.White.copy(0.6f))
            .padding(
                top = 2.dp,
                bottom = 4.dp,
                start = 3.dp,
                end = 3.dp,
            )
            .clip(CircleShape)
            .background(selectedBackground)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = option,
            color = selectedColor
        )
    }
}
