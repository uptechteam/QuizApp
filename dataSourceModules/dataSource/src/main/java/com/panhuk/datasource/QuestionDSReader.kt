package com.panhuk.datasource

import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionDSReader {
  fun getQuestions(
    amount: Int,
    categoryId: String?,
    difficulty: String?,
    type: String?,
    token: String?
  ): Flow<List<Question>?>

  val categories: Flow<List<Category>>
}