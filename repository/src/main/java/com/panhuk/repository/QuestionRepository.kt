package com.panhuk.repository

import kotlinx.coroutines.flow.Flow
import model.Question

interface QuestionRepository {
  val questions: Flow<List<Question?>>
}