package com.panhuk.datasource

import com.panhuk.domain.model.Category
import kotlinx.coroutines.flow.Flow
import com.panhuk.domain.model.Question

interface QuestionDSReader {
  val questions: Flow<List<Question>?>
  val categories: Flow<List<Category>>
}