package model

data class Question(
  val category: Category,
  val correctAnswer: String,
  val difficulty: Difficulty,
  val incorrectAnswers: List<String>,
  val question: String,
  val type: Type
)