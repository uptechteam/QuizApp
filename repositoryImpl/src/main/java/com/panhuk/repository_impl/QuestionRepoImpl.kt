package com.panhuk.repository_impl

import com.panhuk.repository.QuestionRepoReader
import kotlinx.coroutines.flow.Flow
import com.panhuk.domain.model.Question

typealias RepositoryQuestionReader = QuestionRepoReader
typealias DataSourceQuestionReader = com.panhuk.datasource.QuestionDSReader

class QuestionRepoImpl(
  private val questionApiReader: DataSourceQuestionReader
) : RepositoryQuestionReader {

  override val questions: Flow<List<Question>?>
    get() = questionApiReader.questions

}