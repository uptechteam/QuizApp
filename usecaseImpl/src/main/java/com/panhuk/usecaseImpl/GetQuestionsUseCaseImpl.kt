package com.panhuk.usecaseImpl

import com.panhuk.repository.QuestionReader
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.flow.Flow
import model.Question

class GetQuestionsUseCaseImpl(private val questionReader: QuestionReader) : GetQuestionsUseCase {
  override fun getQuestions(): Flow<List<Question?>> {
    return questionReader.questions
  }
}