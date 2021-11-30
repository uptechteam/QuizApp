package com.panhuk.repository

import kotlinx.coroutines.flow.Flow
import com.panhuk.domain.model.Question

interface QuestionRepoReader {
  val questions: Flow<List<Question>?>
}