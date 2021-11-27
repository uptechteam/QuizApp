package com.panhuk.datasourcedi.di

import com.panhuk.api.di.SessionTokenApiComponent
import com.panhuk.api.di.SessionTokenApiComponent.Companion
import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasource.SessionTokenReader
import dagger.Component

@Component(
  dependencies = [
    SessionTokenApiComponent::class
  ],
  modules = [
    SessionTokenModule::class
  ]
)
interface SessionTokenComponent {
  @Api fun sessionTokenApiReader(): SessionTokenReader
  @Cache fun sessionTokenCacheReader(): SessionTokenReader
  fun sessionTokenCache(): SessionTokenCache

  @Component.Builder
  interface Builder {
    fun sessionTokenApiComponent(component: SessionTokenApiComponent): Builder
    fun sessionTokenModule(module: SessionTokenModule): Builder
    fun build(): SessionTokenComponent
  }

  companion object {
    fun create(): SessionTokenComponent =
      DaggerSessionTokenComponent.builder()
        .sessionTokenApiComponent(SessionTokenApiComponent.create())
        .sessionTokenModule(SessionTokenModule())
        .build()
  }
}