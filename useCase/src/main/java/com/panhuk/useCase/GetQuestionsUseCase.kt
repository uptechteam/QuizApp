package com.panhuk.useCase

import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface GetQuestionsUseCase {
  fun getQuestions(): Flow<List<Question>?>
}