package com.example.setupquestionfeature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SetupQuestionsViewModel @Inject constructor(
  private val getQuestionsUseCase: GetQuestionsUseCase,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  //add any type, category ...
  var questions by mutableStateOf(R.array.questions_number_array)
  var categories by mutableStateOf(listOf<String>())
  var difficulties by mutableStateOf(R.array.difficulty_array)
  var types by mutableStateOf(R.array.type_array)
  var isLoading by mutableStateOf(true)

  lateinit var question: String
  lateinit var category: String
  lateinit var difficulty: String
  lateinit var type: String

  init {
    viewModelScope.launch(dispatcher) {
      getQuestionsUseCase.getCategories().collect { category ->
        this@SetupQuestionsViewModel.categories = category.map { it.title }
        isLoading = false
      }
    }
  }
}