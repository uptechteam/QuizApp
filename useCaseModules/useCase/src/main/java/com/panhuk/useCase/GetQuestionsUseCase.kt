package com.panhuk.useCase

import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface GetQuestionsUseCase {
  fun getQuestions(
    amount: Int = 10,
    categoryId: String? = null,
    difficulty: String? = null,
    type: String? = null,
    token: String? = null
  ): Flow<List<Question>?>

  fun getCategories(): Flow<List<Category>>
}