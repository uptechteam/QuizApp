package com.panhuk.datasourceimpl

import com.panhuk.api.api.QuestionApi
import com.panhuk.datasource.QuestionReader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.Category
import model.Difficulty
import model.Question
import model.Type

class QuestionApiDataSource(private val api: QuestionApi) : QuestionReader {
  override val questions: Flow<List<Question?>>
    get() = api.getQuestions().map {
      it.results.map { questionDTO ->
        Question(
          category = Category.valueOf(questionDTO.category),
          correctAnswer = questionDTO.correctAnswer,
          difficulty = Difficulty.valueOf(questionDTO.difficulty),
          incorrectAnswers = questionDTO.incorrectAnswers,
          question = questionDTO.question,
          type = Type.valueOf(questionDTO.type)
        )
      }
    }
}