package com.panhuk.playfeature.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.panhuk.domain.model.Category
import com.panhuk.playfeature.PlayViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

class PlayFactory {

  @AssistedFactory
  interface Factory {
    fun create(
      @Assisted("category") category: Int?,
      @Assisted("difficulty") difficulty: String?,
      @Assisted("question_number") questionNumber: String?,
      @Assisted("type") type: String?
    ): PlayViewModel
  }

  @Suppress("UNCHECKED_CAST")
  companion object {
    fun provideFactory(
      assistedFactory: Factory,
      category: Int?,
      difficulty: String?,
      questionNumber: String?,
      type: String?
    ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
      override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return assistedFactory.create(category, difficulty, questionNumber, type) as T
      }
    }
  }
}