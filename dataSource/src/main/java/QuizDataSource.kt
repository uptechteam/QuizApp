interface QuizDataSource {
    fun getQuestions(amount: Int = 10, category: String, difficulty: String, type: String): String
}