package com.panhuk.api.di

import com.panhuk.api.SessionTokenApi
import dagger.Component

@Component(
  modules = [
    SessionTokenApiModule::class
  ]
)
interface SessionTokenApiComponent {
  fun sessionTokenApi(): SessionTokenApi

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