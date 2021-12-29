package com.panhuk.setupquestionfeature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.core.NOT_FOUND
import com.panhuk.domain.model.Category
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SetupQuestionsViewModel @Inject constructor(
  private val getQuestionsUseCase: GetQuestionsUseCase,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  var questions by mutableStateOf(R.array.questions_number_array)
  var categories by mutableStateOf(listOf<Category>())
  var difficulties by mutableStateOf(R.array.difficulty_array)
  var types by mutableStateOf(R.array.type_array)
  var isLoading by mutableStateOf(true)
  var isQuestionsEmpty by mutableStateOf(true)

  lateinit var question: String
  lateinit var category: Category
  lateinit var difficulty: String
  lateinit var type: String

  init {
    viewModelScope.launch(dispatcher) {
      getQuestionsUseCase.getCategories().collect { category ->
        this@SetupQuestionsViewModel.categories = category
        isLoading = false
      }
    }
  }

  fun updateQuestion(title: Title, text: String) {
    when (title) {
      Title.NUMBER_OF_QUESTIONS -> question = text
      Title.DIFFICULTY -> difficulty = text
      Title.TYPE -> type = text
      Title.CATEGORY -> {
        category = categories.find { text == it.title } ?: Category(ADD_ANY, NOT_FOUND)
      }
    }
  }
}