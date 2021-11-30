package com.panhuk.datasourcedi.di

import com.panhuk.api.api.QuestionApi
import com.panhuk.datasource.QuestionDSReader
import com.panhuk.datasourceimpl.QuestionApiDataSource
import dagger.Module
import dagger.Provides

@Module
class QuestionModule {
  @Provides
  @Api
  fun provideQuestionApiReader(api: QuestionApi): QuestionDSReader =
    QuestionApiDataSource(api)
}