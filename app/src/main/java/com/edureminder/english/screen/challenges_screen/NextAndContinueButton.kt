package com.edureminder.english.screen.challenges_screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NextAndContinueButton(
    onClick: () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }

    // Animate start & end padding
    val sidePadding by animateDpAsState(
        targetValue = if (isPressed) 0.dp else 3.dp,
        animationSpec = spring(dampingRatio = 0.5f, stiffness = 300f),
        label = "SidePadding"
    )

    // Animate bottom padding separately
    val bottomPadding by animateDpAsState(
        targetValue = if (isPressed) 0.dp else 4.dp,
        animationSpec = spring(dampingRatio = 0.5f, stiffness = 300f),
        label = "BottomPadding"
    )

    // Animate background color
    val animatedBackground by animateColorAsState(
        targetValue = if (isPressed) Color.Black else Color.White.copy(alpha = 0.7f),
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing),
        label = "BackgroundAnimation"
    )

    Box(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
            .height(50.dp)
            .shadow(
                elevation = 5.dp,
                shape = CircleShape
            )
            .clip(CircleShape)
            .background(Color.Black)
            .padding(
                bottom = bottomPadding.coerceAtLeast(0.dp),
                start = sidePadding.coerceAtLeast(0.dp),
                end = sidePadding.coerceAtLeast(0.dp)
            )
            .shadow(
                elevation = 5.dp,
                shape = CircleShape
            )
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = CircleShape
            )
            .clip(CircleShape)
            .background(animatedBackground)
            .pointerInteropFilter {
                when (it.action) {
                    android.view.MotionEvent.ACTION_DOWN -> {
                        isPressed = true
                    }
                    android.view.MotionEvent.ACTION_UP -> {
                        isPressed = false
                        onClick() // ✅ Trigger your click here
                    }
                    android.view.MotionEvent.ACTION_CANCEL -> {
                        isPressed = false
                    }
                }
                true
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Continue",
            color = if (isPressed) Color.White else Color.Black,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
