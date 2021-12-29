package com.panhuk.usecaseImpl

import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import com.panhuk.repository.QuestionRepoReader
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetQuestionsUseCaseImpl(private val questionRepository: QuestionRepoReader) :
  GetQuestionsUseCase {
  override fun getQuestions(
    amount: Int, categoryId: String?, difficulty: String?, type: String?, token: String?
  ): Flow<List<Question>?> =
    questionRepository.getQuestions(amount, categoryId, difficulty, type, token)
      .map { questions ->
        questions?.map { question ->
          question.copy(allAnswers = question.allAnswers.shuffled())
        }
      }

  override fun getCategories(): Flow<List<Category>> = questionRepository.categories
}
