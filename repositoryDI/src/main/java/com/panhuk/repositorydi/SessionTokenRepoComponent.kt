package com.panhuk.repositorydi

import com.panhuk.datasourcedi.di.SessionTokenComponent
import dagger.Component

@Component(
  dependencies = [
    SessionTokenComponent::class
  ],
  modules = [
    SessionTokenRepoModule::class
  ]
)
interface SessionTokenRepoComponent {

  @Component.Builder
  interface Builder {
    fun sessionTokenComponent(component: SessionTokenComponent): Builder
    fun sessionTokenRepoModule(module: SessionTokenRepoModule): Builder
    fun build(): SessionTokenRepoComponent
  }

  companion object {
    fun create(): SessionTokenRepoComponent =
      DaggerSessionTokenRepoComponent.builder()
        .sessionTokenComponent(SessionTokenComponent.create())
        .sessionTokenRepoModule(SessionTokenRepoModule())
        .build()
  }
}