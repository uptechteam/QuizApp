package com.panhuk.domain.model

data class Question(
  val category: Category,
  val correctAnswer: String,
  val id: Int,
  val allAnswers: List<String>,
  val questionTitle: String,
  val type: String
)