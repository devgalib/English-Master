package com.edureminder.english.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ChallengeScreenViewModel: ViewModel() {
    var currentQuizIndex by mutableStateOf(1)
}