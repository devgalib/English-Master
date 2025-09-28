package com.edureminder.english.screen.challenges_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.edureminder.english.ui.theme.PrimaryColor

@Composable
fun ProgressBarHeader(){
    val correctAnswer = listOf(2, 4, 6, 8, 10)
    val incorrectAnswer = listOf(1, 3, 5, 7, 9)

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Box (
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = PrimaryColor,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = PrimaryColor
                )
            }
            Row (
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = PrimaryColor,
                        shape = CircleShape
                    )
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LinearProgressIndicator(
                    progress = {
                        0.5f
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(10.dp),
                    color = PrimaryColor,
                    trackColor = Color.LightGray,
                    strokeCap = StrokeCap.Round,
                    drawStopIndicator = {
                        drawCircle(
                            color = PrimaryColor,
                            radius = 10f
                        )
                    }
                )
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.End)
            ) {
                correctAnswer.forEach { ans ->
                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                            .width(10.dp)
                            .clip(CircleShape)
                            .background(PrimaryColor)

                    )
                }
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start)
            ) {
                incorrectAnswer.forEach { ans ->
                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                            .width(10.dp)
                            .clip(CircleShape)
                            .background(Color.Red)

                    )
                }
            }
        }
    }
}
