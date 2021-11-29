package com.panhuk.api.di.questionApi

import com.panhuk.api.api.QuestionApi
import com.panhuk.api.di.base.BaseApiModule
import dagger.Component

@Component(
  modules = [
    QuestionApiModule::class,
    BaseApiModule::class
  ]
)
interface QuestionApiComponent {
  fun questionsApi(): QuestionApi

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