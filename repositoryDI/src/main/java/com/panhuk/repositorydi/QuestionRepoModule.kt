package com.panhuk.repositorydi

import com.panhuk.datasourcedi.di.Api
import com.panhuk.repository.QuestionRepository
import com.panhuk.repository_impl.QuestionRepoImpl
import dagger.Module
import dagger.Provides

typealias RepositoryQuestionReader = QuestionRepository
typealias DataSourceQuestionReader = com.panhuk.datasource.QuestionReader

@Module
class QuestionRepoModule {
  @Provides
  fun provideSessionReader(
    @Api questionApiReader: DataSourceQuestionReader
  ): RepositoryQuestionReader = QuestionRepoImpl(
    questionApiReader
  )
}