package com.panhuk.api.di

import dagger.Component

@Component(
  modules = [
    SessionTokenApiModule::class
  ]
)
interface SessionTokenApiComponent {

  @Component.Builder
  interface Builder {
    fun sessionTokenApiModule(module: SessionTokenApiModule): Builder
    fun build(): SessionTokenApiComponent
  }

  companion object {
    fun create(): SessionTokenApiComponent =
      DaggerSessionTokenApiComponent.builder()
        .sessionTokenApiModule(SessionTokenApiModule())
        .build()
  }
}