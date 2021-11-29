package com.panhuk.repository_impl

import com.panhuk.repository.QuestionReader
import kotlinx.coroutines.flow.Flow
import model.Question

typealias RepositoryQuestionReader = QuestionReader
typealias DataSourceQuestionReader = com.panhuk.datasource.QuestionReader

class QuestionRepoImpl(
  private val questionApiReader: DataSourceQuestionReader
) : RepositoryQuestionReader {

  override val questions: Flow<List<Question?>>
    get() = questionApiReader.questions
}