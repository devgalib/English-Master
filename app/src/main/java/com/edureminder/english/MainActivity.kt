package com.edureminder.english

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edureminder.english.components.common.DuolingoButton
import com.edureminder.english.components.common.DuolingoButtonStyle
import com.edureminder.english.screen.challenges_screen.ChallengesScreen
import com.edureminder.english.ui.theme.EnglishTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnglishTheme {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    DuolingoButton(
//                        text = "SUBMIT",
//                        modifier = Modifier.wrapContentSize(),
//                        style = DuolingoButtonStyle(
//                            normalColor = Color(0xff00B3FD),
//                            pressedColor = Color(0xff009CDC),
//                            textColor = Color.White,
//                            fontSize = 16.sp,
//                            cornerRadius = 16.dp,
//                            offset = 6.dp,
//                            horizontalPadding = 40.dp,
//                            verticalPadding = 16.dp,
//                            customIcon = {
//                                Icon(
//                                    imageVector = Icons.Default.Favorite,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier.size(24.dp)
//                                )
//                            }
//                        ),
//
//                        onClick = {
//                            print("clicked")
//                        }
//                    )
//                }
                ChallengesScreen()
            }
        }
    }
}
