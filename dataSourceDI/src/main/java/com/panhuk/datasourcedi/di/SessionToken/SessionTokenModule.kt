package com.panhuk.datasourcedi.di.SessionToken

import com.panhuk.api.api.SessionTokenApi
import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasource.SessionTokenDSReader
import com.panhuk.datasourcedi.di.Api
import com.panhuk.datasourcedi.di.Cache
import com.panhuk.datasourceimpl.SessionTokenApiDataSource
import com.panhuk.datasourceimpl.SessionTokenLocalDataSource
import dagger.Module
import dagger.Provides

@Module
class SessionTokenModule {

  @Provides
  @Api
  fun provideSessionTokenApiReader(api: SessionTokenApi): SessionTokenDSReader =
    SessionTokenApiDataSource(api)

  @Provides
  @Cache
  fun provideSessionTokenCacheReader(): SessionTokenDSReader =
    SessionTokenLocalDataSource

  @Provides
  fun provideSessionTokenCache(): SessionTokenCache =
    SessionTokenLocalDataSource
}