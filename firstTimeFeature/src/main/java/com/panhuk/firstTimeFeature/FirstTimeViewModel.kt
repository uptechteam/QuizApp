package com.panhuk.firstTimeFeature

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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

  var username: MutableState<String> = mutableStateOf("")

  fun saveUsername() {
    viewModelScope.launch(dispatcher) {
      usernameRepo.saveUsername(username.value)
    }
  }
}