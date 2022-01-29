package com.panhuk.dataSourceimpl.question

import com.panhuk.api.dto.QuestionResponse
import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question

fun QuestionResponse.mapToDomain(): Question {
  return Question(
    category = Category(category),
    correctAnswer = correctAnswer,
    allAnswers = listOf(correctAnswer) + incorrectAnswers,
    questionTitle = question,
    type = type,
    id = id
  )
}

fun Map.Entry<String, String>.mapToDomain(): Category {
  return Category(key, value)
}