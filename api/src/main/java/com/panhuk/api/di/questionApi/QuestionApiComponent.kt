package com.panhuk.api.di.questionApi

import com.panhuk.api.api.QuestionsApi
import com.panhuk.api.di.base.BaseApiModule
import dagger.Component

@Component(
  modules = [
    QuestionApiModule::class,
    BaseApiModule::class
  ]
)
interface QuestionApiComponent {
  fun questionsApi(): QuestionsApi

  @Component.Builder
  interface Builder {
    fun questionsApiModule(module: QuestionApiModule): Builder
    fun build(): QuestionApiComponent
  }

  companion object {
    fun create(): QuestionApiComponent =
      DaggerQuestionApiComponent.builder()
        .questionsApiModule(QuestionApiModule())
        .build()
  }
}