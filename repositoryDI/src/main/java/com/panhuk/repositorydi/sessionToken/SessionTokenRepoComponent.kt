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

  fun getSessionTokenRepoReader(): SessionTokenRepoReader

  @Component.Builder
  interface Builder {
    fun sessionTokenComponent(component: SessionTokenComponent): Builder
    fun sessionTokenRepoModule(module: SessionTokenRepoModule): Builder
    fun build(): SessionTokenRepoComponent
  }

  companion object {
    fun create(context: Context): SessionTokenRepoComponent =
      DaggerSessionTokenRepoComponent.builder()
        .sessionTokenComponent(SessionTokenComponent.create(context))
        .sessionTokenRepoModule(SessionTokenRepoModule())
        .build()
  }
}