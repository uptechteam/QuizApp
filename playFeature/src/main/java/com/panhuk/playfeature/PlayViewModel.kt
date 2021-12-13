package com.panhuk.playfeature

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.core.ERROR
import com.panhuk.domain.model.Question
import com.panhuk.repository.SessionTokenRepoReader
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.Queue
import javax.inject.Inject

class PlayViewModel @Inject constructor(
  private val getQuestionsUseCase: GetQuestionsUseCase,
  private val sessionTokenRepoReader: SessionTokenRepoReader,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  private lateinit var questions: Queue<Question>
  private lateinit var sessionToken: String

  var title: String = ""
  var questionAnswers: List<String> = listOf()
  var totalScore: Int = 0

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
        questions.addAll(qst)
      } else {
        Log.e(ERROR, "questions are null")
      }
    }
  }

  private fun loadQuestion() {
    questions.peek()?.run {
      title = questionTitle
      questionAnswers = allAnswers
    }
  }

  fun checkAnswer(answer: String): Boolean {
    val correctAnswer = questions.peek()?.correctAnswer
    questions.poll()
    loadQuestion()

    return if (correctAnswer == answer) {
      totalScore++
      true
    } else {
      false
    }
  }
}

