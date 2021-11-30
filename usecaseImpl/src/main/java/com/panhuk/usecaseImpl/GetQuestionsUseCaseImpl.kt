package com.panhuk.usecaseImpl

import com.panhuk.domain.model.Question
import com.panhuk.repository.QuestionRepoReader
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetQuestionsUseCaseImpl(private val questionRepository: QuestionRepoReader) :
  GetQuestionsUseCase {
  override fun getQuestions(): Flow<List<Question>?> {
    return questionRepository.questions.map {
      it?.map {
        it.copy(allAnswers = it.allAnswers.shuffled())
      }
    }
  }
}