package com.edureminder.english.screen.challenges_screen.word_matching_quiz

fun checkAnswer(
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
