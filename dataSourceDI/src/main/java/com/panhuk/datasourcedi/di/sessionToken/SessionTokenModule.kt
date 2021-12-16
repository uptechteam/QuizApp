package com.panhuk.datasourcedi.di.sessionToken

import com.panhuk.api.api.SessionTokenApi
import com.panhuk.dataSourceimpl.SessionTokenLocalDataSource
import com.panhuk.datasource.DatastorePreferences
import com.panhuk.datasource.SessionTokenCache
import com.panhuk.dataSourceimpl.SessionTokenApiDataSource
import com.panhuk.datasource.SessionTokenDSReader
import com.panhuk.datasourcedi.di.Api
import com.panhuk.datasourcedi.di.Cache
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
  fun provideSessionTokenCacheReader(datastorePreferences: DatastorePreferences): SessionTokenDSReader =
    SessionTokenLocalDataSource(datastorePreferences)

  @Provides
  fun provideSessionTokenCache(datastorePreferences: DatastorePreferences): SessionTokenCache =
    SessionTokenLocalDataSource(datastorePreferences)
}