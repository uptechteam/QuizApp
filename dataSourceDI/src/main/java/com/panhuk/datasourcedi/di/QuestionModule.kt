package com.panhuk.datasourcedi.di

import com.panhuk.api.api.QuestionApi
import com.panhuk.api.api.SessionTokenApi
import com.panhuk.datasource.QuestionReader
import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasource.SessionTokenReader
import com.panhuk.datasourceimpl.QuestionApiDataSource
import com.panhuk.datasourceimpl.SessionTokenApiDataSource
import com.panhuk.datasourceimpl.SessionTokenLocalDataSource
import dagger.Module
import dagger.Provides

@Module
class QuestionModule {
  @Provides
  @Api
  fun provideQuestionApiReader(api: QuestionApi): QuestionReader =
    QuestionApiDataSource(api)
}