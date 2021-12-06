package com.example.playfeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.domain.model.Question
import com.panhuk.repository.SessionTokenRepoReader
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayViewModel @Inject constructor(
  private val getQuestionsUseCase: GetQuestionsUseCase,
  private val sessionTokenRepoReader: SessionTokenRepoReader,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  private lateinit var questions: List<Question>
  private lateinit var sessionToken: String
  private var numberOfQuestion = 0

  var title: String = ""
  var questionAnswers: List<String> = listOf()
  var totalScore: Int = 0

  init {
    viewModelScope.launch(dispatcher) {
      try {
        getCurrentSessionToken()
      } catch (e: Throwable) {
        generateNewSessionToken()
      } finally {
        getQuestions()
        loadQuestion()
      }
    }
  }

  private suspend fun getCurrentSessionToken() {
    sessionTokenRepoReader.currentSessionToken.collect { sessionTokenRepo ->
      sessionToken = sessionTokenRepo!!
    }
  }

  private suspend fun generateNewSessionToken() {
    sessionTokenRepoReader.generateNewToken().collect { sessionTokenRepo ->
      sessionToken = sessionTokenRepo!!
    }
  }

  private suspend fun getQuestions() {
    getQuestionsUseCase.getQuestions().collect { questionsUseCase ->
      questions = questionsUseCase!!
    }
  }

  private fun loadQuestion() {
    viewModelScope.launch {
      with(questions[numberOfQuestion]) {
        title = questionTitle
        questionAnswers = allAnswers
      }
      numberOfQuestion++
    }
  }

  fun checkAnswer(answer: String): Boolean {
    if (questions[numberOfQuestion].correctAnswer == answer) {
      loadQuestion()
      totalScore++
      return true
    }
    loadQuestion()
    return false
  }
}

