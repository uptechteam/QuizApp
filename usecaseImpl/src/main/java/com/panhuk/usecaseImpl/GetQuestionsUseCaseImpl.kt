package com.panhuk.usecaseImpl

import com.panhuk.domain.model.Question
import com.panhuk.repository.QuestionRepoReader
import com.panhuk.useCase.GetQuestionsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

typealias Questions = Flow<List<Question>?>

class GetQuestionsUseCaseImpl(private val questionRepository: QuestionRepoReader) :
  GetQuestionsUseCase {
  override fun getQuestions(): Questions =
    questionRepository.questions.map { questions ->
      questions?.map { question ->
        question.copy(allAnswers = question.allAnswers.shuffled())
      }
    }
}
