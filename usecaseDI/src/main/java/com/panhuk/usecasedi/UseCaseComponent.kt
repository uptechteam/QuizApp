package com.panhuk.usecasedi

import android.content.Context
import com.panhuk.datasourcedi.di.datastore.DatastoreComponent
import com.panhuk.repositorydi.QuestionRepoComponent
import com.panhuk.useCase.GetQuestionsUseCase
import com.panhuk.useCase.GetUsernameUseCase
import dagger.Component

@Component(
  dependencies = [
    QuestionRepoComponent::class,
    DatastoreComponent::class
  ],
  modules = [
    UseCaseModule::class
  ]
)
interface UseCaseComponent {

  fun getQuestionUseCase(): GetQuestionsUseCase
  fun getUsernameUseCase(): GetUsernameUseCase

  @Component.Builder
  interface Builder {
    fun questionRepoComponent(component: QuestionRepoComponent): Builder
    fun datastoreComponent(component: DatastoreComponent): Builder
    fun useCaseModule(module: UseCaseModule): Builder
    fun build(): UseCaseComponent
  }

  companion object {
    fun create(context: Context): UseCaseComponent =
      DaggerUseCaseComponent.builder()
        .questionRepoComponent(QuestionRepoComponent.create())
        .datastoreComponent(DatastoreComponent.create(context))
        .useCaseModule(UseCaseModule())
        .build()
  }
}