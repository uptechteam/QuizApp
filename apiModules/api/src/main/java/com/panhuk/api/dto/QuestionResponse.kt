package com.panhuk.api.dto

data class QuestionResponse(
  val category: String,
  val correctAnswer: String,
  val incorrectAnswers: List<String>,
  val question: String,
  val type: String,
  val id: Int
)