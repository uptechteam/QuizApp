package com.panhuk.quizapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.repository.FirstTimeRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
  private val firstTimeRepo: FirstTimeRepo,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  var isFirstTime = MutableStateFlow(false)

  init {
    viewModelScope.launch(dispatcher) {
      isFirstTime.emit(firstTimeRepo.isFirstTime().first())
    }
  }
}