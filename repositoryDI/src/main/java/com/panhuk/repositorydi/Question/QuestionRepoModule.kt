package com.panhuk.repositorydi.Question

import com.panhuk.datasourcedi.di.Api
import com.panhuk.repository.QuestionRepoReader
import com.panhuk.repository_impl.QuestionRepoImpl
import dagger.Module
import dagger.Provides

typealias RepositoryQuestionReader = QuestionRepoReader
typealias DataSourceQuestionReader = com.panhuk.datasource.QuestionDSReader

@Module
class QuestionRepoModule {
  @Provides
  fun provideSessionReader(
    @Api questionApiReader: DataSourceQuestionReader
  ): RepositoryQuestionReader = QuestionRepoImpl(
    questionApiReader
  )
}