package com.panhuk.datasourcedi.di

import com.panhuk.datasource.SessionTokenDataSource
import com.panhuk.datasourceimpl.SessionTokenLocalDataSource
import dagger.Component

@Component(
  modules = [
    SessionTokenModule::class
  ]
)
interface SessionTokenComponent {
  fun sessionTokenLocalDataSource(): SessionTokenDataSource =
    SessionTokenLocalDataSource

  @Component.Builder
  interface Builder {
    fun sessionTokenModule(module: SessionTokenModule): Builder
    fun build(): SessionTokenComponent
  }
}