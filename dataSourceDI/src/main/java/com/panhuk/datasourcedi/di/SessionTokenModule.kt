package com.panhuk.datasourcedi.di

import com.panhuk.api.SessionTokenApi
import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasource.SessionTokenReader
import com.panhuk.datasourceimpl.SessionTokenApiDataSource
import com.panhuk.datasourceimpl.SessionTokenLocalDataSource
import dagger.Module
import dagger.Provides

@Module
class SessionTokenModule {

  @Provides
  @Api
  fun provideSessionTokenApiReader(api: SessionTokenApi): SessionTokenReader =
    SessionTokenApiDataSource(api)

  @Provides
  @Cache
  fun provideSessionTokenCacheReader(): SessionTokenReader =
    SessionTokenLocalDataSource

  @Provides
  fun provideSessionTokenCache(): SessionTokenCache =
    SessionTokenLocalDataSource
}