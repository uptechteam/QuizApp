package com.panhuk.datasource

import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionDSReader {
  val questions: Flow<List<Question>?>
  val categories: Flow<List<Category>>
}