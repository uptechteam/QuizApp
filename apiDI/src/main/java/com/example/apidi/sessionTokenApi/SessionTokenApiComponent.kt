package com.example.apidi.sessionTokenApi

import com.panhuk.api.api.SessionTokenApi
import com.example.apidi.base.BaseApiModule
import dagger.Component

@Component(
  modules = [
    SessionTokenApiModule::class,
    BaseApiModule::class
  ]
)
interface SessionTokenApiComponent {
  fun sessionTokenApi(): SessionTokenApi

  @Component.Builder
  interface Builder {
    fun sessionTokenApiModule(module: SessionTokenApiModule): Builder
    fun baseApiModule(module: BaseApiModule): Builder
    fun build(): SessionTokenApiComponent
  }

  companion object {
    fun create(): SessionTokenApiComponent =
      DaggerSessionTokenApiComponent.builder()
        .sessionTokenApiModule(SessionTokenApiModule())
        .baseApiModule(BaseApiModule())
        .build()
  }
}