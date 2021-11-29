package com.panhuk.usecaseImpl

import com.panhuk.repository.QuestionRepository
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.flow.Flow
import model.Question

class GetQuestionsUseCaseImpl(private val questionRepository: QuestionRepository) :
  GetQuestionsUseCase {
  override fun getQuestions(): Flow<List<Question?>> {
    return questionRepository.questions
  }
}