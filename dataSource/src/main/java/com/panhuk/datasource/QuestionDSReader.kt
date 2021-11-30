package com.panhuk.datasource

import kotlinx.coroutines.flow.Flow
import com.panhuk.domain.model.Question

interface QuestionDSReader {
  val questions: Flow<List<Question>?>
}