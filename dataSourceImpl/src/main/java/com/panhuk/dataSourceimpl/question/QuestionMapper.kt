package com.panhuk.dataSourceimpl.question

import com.panhuk.api.dto.CategoryResponse
import com.panhuk.api.dto.QuestionResponse
import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question

fun QuestionResponse.mapToDomain(): Question {
  return Question(
    category = Category(category),
    correctAnswer = correctAnswer,
    difficulty = difficulty,
    allAnswers = incorrectAnswers + correctAnswer,
    questionTitle = question,
    type = type
  )
}

fun CategoryResponse.mapToDomain(): Category {
  return Category(name)
}