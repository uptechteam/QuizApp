package com.panhuk.playfeature

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.core.NOT_FOUND
import com.panhuk.core.getDrawableRes
import com.panhuk.domain.model.Leaderboard
import com.panhuk.domain.model.Question
import com.panhuk.repository.LeaderboardRepo
import com.panhuk.repository.SessionTokenRepoReader
import com.panhuk.repository.UsernameRepo
import com.panhuk.useCase.GetQuestionsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import java.time.LocalDateTime
import java.util.LinkedList
import java.util.Queue

class PlayViewModel @AssistedInject constructor(
  private val getQuestionsUseCase: GetQuestionsUseCase,
  private val sessionTokenRepoReader: SessionTokenRepoReader,
  private val dispatcher: CoroutineDispatcher,
  private val leaderboardRepo: LeaderboardRepo,
  private val usernameRepo: UsernameRepo,
  @Assisted("category") val category: String?,
  @Assisted("question_number") val questionNumber: String?,
) : ViewModel() {

  private var questions: Queue<Question> = LinkedList()
  private lateinit var sessionToken: String
  private var _timer: CountDownTimer

  var timer by mutableStateOf(0)
  var timerIsActive by mutableStateOf(true)
  var title by mutableStateOf("")
  var questionAnswers by mutableStateOf(listOf<String>())
  var totalScore by mutableStateOf(0)
  var totalNumberOfQuestions by mutableStateOf(0)
  var currentQuestionNumber by mutableStateOf(0)
  var isLastQuestion by mutableStateOf(false)
  var isLoading by mutableStateOf(true)
  var isQuestionsEmpty by mutableStateOf(true)

  init {
    _timer = object : CountDownTimer(10000, 1000) {
      override fun onTick(millisUntilFinished: Long) {
        timer = (millisUntilFinished / 1000).toInt()
      }

      override fun onFinish() {
        viewModelScope.launch(dispatcher) {
          timerIsActive = false
          delay(200) // is needed to update timerIsActive status for compose fragment
          checkAnswer()
        }
      }
    }

    viewModelScope.launch(dispatcher) {
      try {
        generateNewSessionToken()
        getQuestions()
        loadQuestion()
        initTimer()
      } catch (e: Exception) {
        Timber.e(e.toString())
      }
    }
  }

  private suspend fun generateNewSessionToken() {
    sessionTokenRepoReader.generateNewToken().collect { token ->
      if (token != null) {
        sessionToken = token
      } else {
        Timber.e("sessionToken is null")
      }
    }
  }

  private suspend fun getQuestions() {
    var tempCategory: String? = category.toString()
    if (tempCategory == NOT_FOUND) {
      tempCategory = null
    }

    if (questionNumber != null) {
      getQuestionsUseCase.getQuestions(
        limit = questionNumber.toInt(),
        category = tempCategory
      ).collect { qst ->
        if (qst != null) {
          questions.clear()
          questions.addAll(qst)
          totalNumberOfQuestions = questions.size
          isLoading = false
          isQuestionsEmpty = false
        } else {
          Timber.e("questions are null")
        }
      }
    }
  }

  fun checkAnswer(answer: String = ""): Boolean {
    val correctAnswer = questions.peek()?.correctAnswer
    afterCheckUpdateQuestion()

    return when (correctAnswer) {
      answer -> {
        totalScore++
        true
      }
      else -> false
    }
  }

  private fun afterCheckUpdateQuestion() {
    deleteCurrentQuestion()
    checkLastQuestion()

    if (!isLastQuestion) {
      loadQuestion()
      reInitTimer()
    }
  }

  private fun loadQuestion() {
    questions.peek()?.run {
      title = questionTitle
      questionAnswers = allAnswers
      currentQuestionNumber++
    }
  }

  private fun deleteCurrentQuestion() {
    questions.poll()
  }

  fun saveScore() {
    viewModelScope.launch(dispatcher) {
      usernameRepo.getUsername().collect { username ->
        val leaderboard = Leaderboard(
          imageId = getDrawableRes(),
          username = username.toString(),
          scoreLocalDate = LocalDateTime.now(),
          score = totalScore
        )
        leaderboardRepo.insert(leaderboard)
      }
    }
  }

  private fun reInitTimer() {
    _timer.cancel()
    _timer.start()
    timerIsActive = true
  }

  private fun checkLastQuestion() {
    isLastQuestion = (currentQuestionNumber == totalNumberOfQuestions)
  }

  private fun initTimer() {
    _timer.start()
  }
}