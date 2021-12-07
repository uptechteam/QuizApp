package com.panhuk.datasourcedi.di

import com.example.apidi.questionApi.QuestionApiComponent
import com.panhuk.datasource.QuestionDSReader
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

  @Api fun questionApiReader(): QuestionDSReader

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