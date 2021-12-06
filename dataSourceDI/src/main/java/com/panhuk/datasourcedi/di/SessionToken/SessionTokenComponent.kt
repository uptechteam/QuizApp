package com.panhuk.datasourcedi.di.SessionToken

import com.panhuk.api.di.sessionTokenApi.SessionTokenApiComponent
import com.panhuk.datasource.DatastorePreferences
import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasource.SessionTokenDSReader
import com.panhuk.datasourcedi.di.Api
import com.panhuk.datasourcedi.di.Cache
import com.panhuk.datasourcedi.di.DaggerSessionTokenComponent
import com.panhuk.datasourcedi.di.Datastore.DatastoreComponent
import dagger.Component

@Component(
  dependencies = [
    SessionTokenApiComponent::class,
    DatastoreComponent::class
  ],
  modules = [
    SessionTokenModule::class
  ]
)
interface SessionTokenComponent {

  @Api fun sessionTokenApiReader(): SessionTokenDSReader
  @Cache fun sessionTokenCacheReader(): SessionTokenDSReader
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