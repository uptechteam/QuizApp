package com.panhuk.settingsfeature

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.repository.UsernameRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
  private val usernameRepo: UsernameRepo,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  var username: MutableState<String> = mutableStateOf("")

  init {
    viewModelScope.launch(dispatcher) {
      getUsername()
    }
  }

  private suspend fun getUsername() {
    usernameRepo.getUsername().collect { usr ->
      username.value = usr ?: ""
    }
  }

  fun saveUsername() {
    viewModelScope.launch(dispatcher) {
      usernameRepo.saveUsername(username.value)
    }
  }
}