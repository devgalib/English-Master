package com.edureminder.english.screen.challenges_screen.word_matching_quiz

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class QuizItem(val id: Int, val text: String)

@Composable
fun WordMatchingQuiz(modifier: Modifier = Modifier) {
    // Words (Bangla) and Meanings (English) with same ID
    val words = listOf(
        QuizItem(1, "বড়"),
        QuizItem(2, "ছোট"),
        QuizItem(3, "চা"),
        QuizItem(4, "বাড়ি"),
        QuizItem(5, "ঠান্ডা")
    )
    val meanings = listOf(
        QuizItem(3, "tea"),
        QuizItem(1, "big"),
        QuizItem(5, "cold"),
        QuizItem(4, "house"),
        QuizItem(2, "small"),
    )// Shuffle meanings so order is different

    var selectedWord by remember { mutableStateOf<QuizItem?>(null) }
    var selectedMeaning by remember { mutableStateOf<QuizItem?>(null) }
    var matchedIds by remember { mutableStateOf(setOf<Int>()) }
    var message by remember { mutableStateOf("") }

    val allMatched = matchedIds.size == words.size

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()

        ) {
            // Words column
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                words.forEach { word ->
                    val isSelected = selectedWord?.id == word.id
                    val isMatched = matchedIds.contains(word.id)

                    val shadowColor by animateColorAsState(
                        targetValue = when {
                            isMatched -> Color.Gray
                            isSelected -> Color(0xFF4CAF50)
                            else -> Color.Gray
                        }, label = ""
                    )
                    val backgroundColor by animateColorAsState(
                        targetValue = when {
                            isMatched -> Color.LightGray
                            isSelected -> Color(0xFF4CAF50)
                            else -> Color.White
                        }, label = ""
                    )
                    val contentColor by animateColorAsState(
                        targetValue = when {
                            isMatched -> Color.Gray
                            isSelected -> Color.White
                            else -> Color.Black
                        }, label = ""
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .clip(CircleShape)
                            .background(shadowColor)
                            .shadow(
                                elevation = 4.dp,
                                shape = CircleShape
                            )
                            .padding(
                                bottom = 4.dp,
                                top = 2.dp,
                                start = 3.dp,
                                end = 3.dp
                            )
                            .clip(CircleShape)
                            .background(backgroundColor)
                            .clickable(
                                enabled = !isMatched
                            ){
                            selectedWord = word
                            if (selectedMeaning != null) {
                                checkAnswer(
                                    word,
                                    selectedMeaning!!,
                                    matchedIds,
                                    onCorrect = { matchedIds = it; message = "✅ Correct!" },
                                    onWrong = { message = "❌ Wrong! Try again" }
                                )
                                selectedWord = null
                                selectedMeaning = null
                            }
                        },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "${word.id}. ${word.text}",
                            color = contentColor,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            // Meanings column
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                meanings.forEach { meaning ->
                    val isSelected = selectedMeaning?.id == meaning.id
                    val isMatched = matchedIds.contains(meaning.id)


                    val shadowColor by animateColorAsState(
                        targetValue = when {
                            isMatched -> Color.Gray
                            isSelected -> Color(0xFF4CAF50)
                            else -> Color.Gray
                        }, label = ""
                    )
                    val backgroundColor by animateColorAsState(
                        targetValue = when {
                            isMatched -> Color.LightGray
                            isSelected -> Color(0xFF4CAF50)
                            else -> Color.White
                        }, label = ""
                    )
                    val contentColor by animateColorAsState(
                        targetValue = when {
                            isMatched -> Color.Gray
                            isSelected -> Color.White
                            else -> Color.Black
                        }, label = ""
                    )



                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .clip(CircleShape)
                            .background(shadowColor)
                            .padding(
                                bottom = 4.dp,
                                top = 2.dp,
                                start = 3.dp,
                                end = 3.dp
                            )
                            .shadow(
                                elevation = 4.dp,
                                shape = CircleShape
                            )
                            .clip(CircleShape)
                            .background(backgroundColor)
                            .clickable(
                                enabled = !isMatched
                            ){
                                selectedMeaning = meaning
                                if (selectedWord != null) {
                                    checkAnswer(
                                        selectedWord!!,
                                        meaning,
                                        matchedIds,
                                        onCorrect = { matchedIds = it; message = "✅ Correct!" },
                                        onWrong = { message = "❌ Wrong! Try again" }
                                    )
                                    selectedWord = null
                                    selectedMeaning = null
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "${meaning.id}. ${meaning.text}",
                            color = contentColor,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Text(message)

        if (allMatched) {
            Spacer(Modifier.height(16.dp))
            Button(onClick = { /* Go to next quiz */ }) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WordMatchingQuizPreview(){
    WordMatchingQuiz()
}
