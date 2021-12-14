package com.panhuk.usecasedi

import com.panhuk.repositorydi.QuestionRepoComponent
import com.panhuk.useCase.GetQuestionsUseCase
import dagger.Component


@Component(
  dependencies = [
    QuestionRepoComponent::class
  ],
  modules = [
    UseCaseModule::class
  ]
)
interface UseCaseComponent {

  fun getQuestionUseCase(): GetQuestionsUseCase

  @Component.Builder
  interface Builder {
    fun questionRepoComponent(component: QuestionRepoComponent): Builder
    fun useCaseModule(module: UseCaseModule): Builder
    fun build(): UseCaseComponent
  }

  companion object {
    fun create(): UseCaseComponent =
      DaggerUseCaseComponent.builder()
        .questionRepoComponent(QuestionRepoComponent.create())
        .useCaseModule(UseCaseModule())
        .build()
  }
}