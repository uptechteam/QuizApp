package com.panhuk.api.di.questionApi

import com.panhuk.api.api.QuestionsApi
import com.panhuk.api.api.SessionTokenApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class QuestionApiModule {
  @Provides
  fun provideQuestionApi(retrofit: Retrofit): QuestionsApi =
    retrofit.create(QuestionsApi::class.java)
}