package com.panhuk.repository_impl.question

import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import com.panhuk.repository.QuestionRepoReader
import kotlinx.coroutines.flow.Flow

typealias RepositoryQuestionReader = QuestionRepoReader
typealias DataSourceQuestionReader = com.panhuk.datasource.QuestionDSReader

class QuestionRepoImpl(
  private val questionApiReader: DataSourceQuestionReader
) : RepositoryQuestionReader {

  override fun getQuestions(
    amount: Int,
    categoryId: String?,
    difficulty: String?,
    type: String?,
    token: String?
  ): Flow<List<Question>?> =
    questionApiReader.getQuestions(amount, categoryId, difficulty, type, token)

  override val categories: Flow<List<Category>>
    get() = questionApiReader.categories
}