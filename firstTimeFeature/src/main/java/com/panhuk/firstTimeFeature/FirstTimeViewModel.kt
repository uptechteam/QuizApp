package com.panhuk.firstTimeFeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.repository.UsernameRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class FirstTimeViewModel @Inject constructor(
  private val usernameRepo: UsernameRepo,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  fun saveUsername(username: String) {
    viewModelScope.launch(dispatcher) {
      usernameRepo.saveUsername(username)
    }
  }
}