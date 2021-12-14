package com.panhuk.core.di

import dagger.Component
import kotlinx.coroutines.CoroutineDispatcher

@Component(
  modules = [
    CoreModule::class
  ]
)
interface CoreComponent {

  fun getCoroutineDispatcher(): CoroutineDispatcher

  @Component.Builder
  interface Builder {
    fun coreModule(module: CoreModule): Builder
    fun build(): CoreComponent
  }

  companion object {
    fun create(): CoreComponent =
      DaggerCoreComponent.builder()
        .coreModule(CoreModule())
        .build()
  }
}