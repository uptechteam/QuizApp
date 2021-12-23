package com.panhuk.useCase

import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface GetQuestionsUseCase {
  fun getQuestions(): Flow<List<Question>?>
  fun getCategories(): Flow<List<Category>>
}