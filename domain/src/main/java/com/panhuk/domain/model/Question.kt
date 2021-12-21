package com.panhuk.domain.model

data class Question(
  val category: Category,
  val correctAnswer: String,
  val difficulty: String,
  val allAnswers: List<String>,
  val questionTitle: String,
  val type: String
)