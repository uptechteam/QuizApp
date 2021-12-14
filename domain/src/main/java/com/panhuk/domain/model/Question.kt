package com.panhuk.domain.model

data class Question(
  val category: Category,
  val correctAnswer: String,
  val difficulty: Difficulty,
  val allAnswers: List<String>,
  val questionTitle: String,
  val type: Type
)