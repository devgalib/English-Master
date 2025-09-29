package com.edureminder.english.screen.challenges_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edureminder.english.screen.challenges_screen.word_matching_quiz.WordMatchingQuiz
import com.edureminder.english.ui.theme.PrimaryColor
import com.edureminder.english.view_model.ChallengeScreenViewModel

@Composable
fun ChallengesScreen () {
    val manageViewModel = ChallengeScreenViewModel()

    Scaffold (

    ) { innerPadding ->
        Box (
            modifier = Modifier
                .padding(innerPadding)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White,
                            PrimaryColor
                        )
                    )
                )
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProgressBarHeader()
                when(manageViewModel.currentQuizIndex){
                    0 -> TextToImageSelectQuiz(
                            modifier = Modifier
                                .weight(1f)
                    )
                    1 -> WordMatchingQuiz(
                          modifier = Modifier
                            .weight(1f)
                    )
                }
            }
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 8.dp, start = 10.dp, end = 10.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 250.dp)
                        .clip(MaterialTheme.shapes.large)
                        .background(Color.White)
                        .padding(10.dp)
                ) {
                    Column (
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Wrong",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Red,
                        )
                        Box (
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(PrimaryColor)
                                .padding(horizontal = 5.dp, vertical = 2.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Solution",
                                color = Color.White,
                                fontSize = 13.sp
                            )
                        }
                        Text(
                            text = "পরিবার",
                            color = Color.Black,
                        )
                    }
                }
                NextAndContinueButton(
                    onClick = {
                        Log.d("NextAndContinueButton", "Clicked")
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChallengesScreenPreview(){
    ChallengesScreen()
}



