package com.panhuk.repository

import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepoReader {
  val questions: Flow<List<Question>?>
  val categories: Flow<List<Category>>
}