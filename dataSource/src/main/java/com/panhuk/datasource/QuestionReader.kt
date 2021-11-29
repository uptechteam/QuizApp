package com.panhuk.datasource

import kotlinx.coroutines.flow.Flow
import model.Question

interface QuestionReader {
  val questions: Flow<List<Question?>>
}