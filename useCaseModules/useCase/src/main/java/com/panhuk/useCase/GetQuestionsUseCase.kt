package com.panhuk.useCase

import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface GetQuestionsUseCase {
  fun getQuestions(
    limit: Int = 10,
    category: String? = null,
  ): Flow<List<Question>?>

  fun getCategories(): Flow<List<Category>>
}