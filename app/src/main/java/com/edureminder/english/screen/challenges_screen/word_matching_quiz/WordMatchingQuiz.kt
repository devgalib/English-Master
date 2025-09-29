package com.edureminder.english.screen.challenges_screen.word_matching_quiz

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Words column
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                words.forEach { word ->
                    val isSelected = selectedWord?.id == word.id
                    val isMatched = matchedIds.contains(word.id)

                    val backgroundColor by animateColorAsState(
                        targetValue = when {
                            isMatched -> Color.Gray
                            isSelected -> Color(0xFF2196F3)
                            else -> Color.LightGray
                        }, label = ""
                    )

                    Button(
                        onClick = {
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
                        enabled = !isMatched,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = backgroundColor,
                            disabledContainerColor = Color.DarkGray
                        )
                    ) {
                        Text("${word.id}. ${word.text}")
                    }
                }
            }

            // Meanings column
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                meanings.forEach { meaning ->
                    val isSelected = selectedMeaning?.id == meaning.id
                    val isMatched = matchedIds.contains(meaning.id)

                    val backgroundColor by animateColorAsState(
                        targetValue = when {
                            isMatched -> Color.Gray
                            isSelected -> Color(0xFF4CAF50)
                            else -> Color.LightGray
                        }, label = ""
                    )

                    Button(
                        onClick = {
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
                        enabled = !isMatched,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = backgroundColor,
                            disabledContainerColor = Color.DarkGray
                        )
                    ) {
                        Text("${meaning.id}. ${meaning.text}")
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

private fun checkAnswer(
    word: QuizItem,
    meaning: QuizItem,
    matchedIds: Set<Int>,
    onCorrect: (Set<Int>) -> Unit,
    onWrong: () -> Unit
) {
    if (word.id == meaning.id) {
        onCorrect(matchedIds + word.id)
    } else {
        onWrong()
    }
}
