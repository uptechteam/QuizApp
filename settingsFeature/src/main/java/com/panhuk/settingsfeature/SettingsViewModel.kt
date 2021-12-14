package com.panhuk.settingsfeature

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.useCase.GetUsernameUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
  private val usernameUseCase: GetUsernameUseCase,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  var username: MutableState<String> = mutableStateOf("")

  init {
    viewModelScope.launch(dispatcher) {
      getUsername()
    }
  }

  private suspend fun getUsername() {
    usernameUseCase.getUsername().collect { usr ->
      username.value = usr ?: ""
    }
  }

  fun saveUsername() {
    viewModelScope.launch(dispatcher) {
      usernameUseCase.saveUsername(username.value)
    }
  }
}