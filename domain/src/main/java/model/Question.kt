package model

import com.google.gson.annotations.SerializedName

data class Question(
  val category: Category,
  @SerializedName("correct_answer")
  val correctAnswer: String,
  val difficulty: Difficulty,
  @SerializedName("incorrect_answers")
  val incorrectAnswers: List<String>,
  val question: String,
  val type: Type
)