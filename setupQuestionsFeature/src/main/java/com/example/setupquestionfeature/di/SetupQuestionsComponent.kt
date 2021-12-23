package com.example.setupquestionfeature.di

import com.example.setupquestionfeature.SetupQuestionsFragment
import com.panhuk.core.di.CoreComponent
import com.panhuk.repositorydi.SessionTokenRepoComponent
import com.panhuk.usecasedi.UseCaseComponent
import dagger.Component

@Component(
  dependencies = [
    UseCaseComponent::class,
    CoreComponent::class
  ]
)
interface SetupQuestionsComponent {

  @Component.Builder
  interface Builder {
    fun useCaseComponent(component: UseCaseComponent): Builder
    fun coreComponent(component: CoreComponent): Builder
    fun build(): SetupQuestionsComponent
  }

  fun inject(SetupQuestionsFragment: SetupQuestionsFragment)

  companion object {
    fun create(): SetupQuestionsComponent =
      DaggerSetupQuestionsComponent.builder()
        .useCaseComponent(UseCaseComponent.create())
        .coreComponent(CoreComponent.create())
        .build()
  }
}
