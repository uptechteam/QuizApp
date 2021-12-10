package com.panhuk.apidi.questionApi

import com.panhuk.api.api.QuestionApi
import com.panhuk.apidi.base.BaseApiModule
import dagger.Component
import kotlinx.coroutines.CoroutineDispatcher

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
    fun baseApiModule(module: BaseApiModule): Builder
    fun build(): QuestionApiComponent
  }

  companion object {
    fun create(): QuestionApiComponent =
      DaggerQuestionApiComponent.builder()
        .questionsApiModule(QuestionApiModule())
        .baseApiModule(BaseApiModule())
        .build()
  }
}