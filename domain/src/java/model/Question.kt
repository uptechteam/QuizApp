package model

data class Question(
    val category: Category,
    val correct_answer: String,
    val difficulty: Difficulty,
    val incorrect_answers: List<String>,
    val question: String,
    val type: Type
)