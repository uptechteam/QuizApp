package com.panhuk.useCase

import model.Question
import kotlinx.coroutines.flow.Flow

interface GetQuestionsUseCase {
  fun getQuestions(): Flow<List<Question?>>
}