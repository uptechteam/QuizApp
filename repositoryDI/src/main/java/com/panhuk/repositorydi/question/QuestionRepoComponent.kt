package com.panhuk.repositorydi

import com.panhuk.datasourcedi.di.question.QuestionComponent
import com.panhuk.repository.QuestionRepoReader
import com.panhuk.repositorydi.question.QuestionRepoModule
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
  fun getQuestionRepoReader(): QuestionRepoReader

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