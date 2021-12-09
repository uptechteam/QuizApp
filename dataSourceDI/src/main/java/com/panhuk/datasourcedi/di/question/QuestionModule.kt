package com.panhuk.datasourcedi.di.question

import com.panhuk.api.api.QuestionApi
import com.panhuk.datasource.QuestionDSReader
import com.panhuk.datasourcedi.di.Api
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