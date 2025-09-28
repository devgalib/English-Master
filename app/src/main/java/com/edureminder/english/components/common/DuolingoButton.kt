package com.edureminder.english.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class DuolingoButtonStyle(
    val normalColor: Color = Color(0xff00B3FD),
    val pressedColor: Color = Color(0xff009CDC),
    val textColor: Color = Color.White,
    val fontSize: TextUnit = 18.sp,
    val cornerRadius: Dp = 8.dp,
    val offset: Dp = 4.dp,
    val horizontalPadding: Dp = 40.dp,
    val verticalPadding: Dp = 16.dp,
    val customIcon: @Composable (() -> Unit)? = null
)

@Composable
fun DuolingoButton(
    text: String,
    onClick: () -> Unit,
    style: DuolingoButtonStyle = DuolingoButtonStyle(),
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(

        modifier = modifier
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null
            )
            .drawWithCache {
                onDrawBehind {
                    drawRoundRect(
                        color = style.pressedColor,
                        cornerRadius = CornerRadius(
                            style.cornerRadius.toPx(),
                            style.cornerRadius.toPx()
                        ),
                        size = Size(
                            size.width,
                            size.height
                        )
                    )
                    if (!isPressed) {
                        drawRoundRect(
                            color = style.normalColor,
                            cornerRadius = CornerRadius(
                                style.cornerRadius.toPx(),
                                style.cornerRadius.toPx()
                            ),
                            size = Size(
                                size.width,
                                size.height - style.offset.toPx()
                            )
                        )
                    }
                }
            },

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    top = style.verticalPadding,
                    bottom = style.verticalPadding,
                    start = style.horizontalPadding,
                    end = style.horizontalPadding
                )
                .align(Alignment.Center)
                .offset(
                    x = 0.dp,
                    y = if (isPressed) 0.dp else (-style.offset / 2)
                )
        ) {
            // if customIcon is set, then show it
            style.customIcon?.let { icon ->
                icon()
                Spacer(modifier = Modifier.width(8.dp))
            }

            Text(
                text = text,
                fontSize = style.fontSize,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                color = style.textColor
            )
        }
    }
}