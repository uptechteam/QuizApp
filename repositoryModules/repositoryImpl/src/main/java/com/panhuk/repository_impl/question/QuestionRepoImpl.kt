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
    limit: Int,
    category: String?,
  ): Flow<List<Question>?> =
    questionApiReader.getQuestions(limit, category)

  override val categories: Flow<List<Category>>
    get() = questionApiReader.categories
}