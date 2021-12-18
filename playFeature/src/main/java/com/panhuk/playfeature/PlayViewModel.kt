package com.panhuk.playfeature

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.core.ERROR
import com.panhuk.domain.model.Question
import com.panhuk.repository.SessionTokenRepoReader
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.LinkedList
import java.util.Queue
import javax.inject.Inject

class PlayViewModel @Inject constructor(
  private val getQuestionsUseCase: GetQuestionsUseCase,
  private val sessionTokenRepoReader: SessionTokenRepoReader,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  private var questions: Queue<Question> = LinkedList()
  private lateinit var sessionToken: String

  var title by mutableStateOf("")
  var questionAnswers by mutableStateOf(listOf<String>())
  var totalScore by mutableStateOf(0)
  var totalNumberOfQuestions by mutableStateOf(0)
  var currentQuestionNumber by mutableStateOf(0)
  var isLastQuestion by mutableStateOf(false)

  init {
    viewModelScope.launch(dispatcher) {
      try {
        generateNewSessionToken()
        getQuestions()
        loadQuestion()
      } catch (e: Exception) {
        Log.e(ERROR, e.toString())
      }
    }
  }

  private suspend fun generateNewSessionToken() {
    sessionTokenRepoReader.generateNewToken().collect { token ->
      if (token != null) {
        sessionToken = token
      } else {
        Log.e(ERROR, "sessionToken is null")
      }
    }
  }

  private suspend fun getQuestions() {
    getQuestionsUseCase.getQuestions().collect { qst ->
      if (qst != null) {
        questions.clear()
        questions.addAll(qst)
        totalNumberOfQuestions = questions.size
      } else {
        Log.e(ERROR, "questions are null")
      }
    }
  }

  private fun loadQuestion() {
    questions.peek()?.run {
      title = questionTitle
      questionAnswers = allAnswers
      currentQuestionNumber++
    }
  }

  fun checkAnswer(answer: String): Boolean {
    val correctAnswer = questions.peek()?.correctAnswer
    questions.poll()
    isLastQuestion()
    loadQuestion()

    return if (correctAnswer == answer) {
      totalScore++
      true
    } else {
      false
    }
  }

  private fun isLastQuestion() {
    isLastQuestion = (currentQuestionNumber == totalNumberOfQuestions)
  }
}

