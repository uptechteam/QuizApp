package com.panhuk.api.di.questionApi

import com.panhuk.api.api.QuestionApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class QuestionApiModule {
  @Provides
  fun provideQuestionApi(retrofit: Retrofit): QuestionApi =
    retrofit.create(QuestionApi::class.java)
}