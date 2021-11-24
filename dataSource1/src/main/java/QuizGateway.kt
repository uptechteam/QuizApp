interface QuizGateway {
    fun getSessionToken(): String
    fun getQuestions(amount: Int = 10, category: String, difficulty: String, type: String): String
}