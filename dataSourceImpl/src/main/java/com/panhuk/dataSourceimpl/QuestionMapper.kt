package com.panhuk.dataSourceimpl

import com.panhuk.api.dto.QuestionResponse
import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Difficulty
import com.panhuk.domain.model.Question
import com.panhuk.domain.model.Type

fun QuestionResponse.mapToDomain(): Question {
  return Question(
    category = Category.valueOf(category),
    correctAnswer = correctAnswer,
    difficulty = Difficulty.valueOf(difficulty),
    allAnswers = incorrectAnswers + correctAnswer,
    question = question,
    type = Type.valueOf(type)
  )
}