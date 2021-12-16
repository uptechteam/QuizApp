package com.panhuk.quizapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.repository.FirstTimeRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
  private val firstTimeRepo: FirstTimeRepo,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  var isFirstTime: Boolean = false

  fun isFirstTimeCheck(): Boolean {
    viewModelScope.launch(dispatcher) {
      firstTimeRepo.isFirstTime().collect { value ->
        isFirstTime = value
      }
    }
    return isFirstTime
  }
}