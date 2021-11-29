package com.panhuk.datasourcedi.di

import com.panhuk.api.di.questionApi.QuestionApiComponent
import com.panhuk.api.di.sessionTokenApi.SessionTokenApiComponent
import com.panhuk.datasource.QuestionReader
import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasource.SessionTokenReader
import dagger.Component

@Component(
  dependencies = [
    QuestionApiComponent::class
  ],
  modules = [
    QuestionModule::class
  ]
)
interface QuestionComponent {

  @Api fun sessionTokenApiReader(): QuestionReader

  @Component.Builder
  interface Builder {
    fun questionApiComponent(component: QuestionApiComponent): Builder
    fun questionApiModule(module: QuestionModule): Builder
    fun build(): QuestionComponent
  }

  companion object {
    fun create(): QuestionComponent =
      DaggerQuestionComponent.builder()
        .questionApiComponent(QuestionApiComponent.create())
        .questionApiModule(QuestionModule())
        .build()
  }
}