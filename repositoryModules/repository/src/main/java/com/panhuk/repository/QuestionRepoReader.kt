package com.panhuk.repository

import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepoReader {
  fun getQuestions(
    limit: Int,
    category: String?,
  ): Flow<List<Question>?>

  val categories: Flow<List<Category>>
}