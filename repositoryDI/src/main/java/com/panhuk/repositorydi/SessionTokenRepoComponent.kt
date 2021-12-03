package com.panhuk.repositorydi

import com.panhuk.datasourcedi.di.SessionTokenComponent
import com.panhuk.repository.SessionTokenRepoReader
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

  fun getSessionTokenRepoReader(): SessionTokenRepoReader

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