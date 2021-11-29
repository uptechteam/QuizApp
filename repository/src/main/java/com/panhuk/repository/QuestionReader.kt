package com.panhuk.repository

import kotlinx.coroutines.flow.Flow
import model.Question

interface QuestionReader {
  val questions: Flow<List<Question?>>
}