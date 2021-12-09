package com.panhuk.repositorydi.Question

import com.panhuk.datasourcedi.di.question.QuestionComponent
import dagger.Component

@Component(
  dependencies = [
    QuestionComponent::class
  ],
  modules = [
    QuestionRepoModule::class
  ]
)
interface QuestionRepoComponent {

  @Component.Builder
  interface Builder {
    fun questionComponent(component: QuestionComponent): Builder
    fun questionRepoModule(module: QuestionRepoModule): Builder
    fun build(): QuestionRepoComponent
  }

  companion object {
    fun create(): QuestionRepoComponent =
      DaggerQuestionRepoComponent.builder()
        .questionComponent(QuestionComponent.create())
        .questionRepoModule(QuestionRepoModule())
        .build()
  }
}