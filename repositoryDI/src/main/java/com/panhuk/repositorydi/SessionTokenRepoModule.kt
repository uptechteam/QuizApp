package com.panhuk.repositorydi

import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasourcedi.di.Api
import com.panhuk.datasourcedi.di.Cache
import com.panhuk.repository.SessionTokenReader
import com.panhuk.repository_impl.SessionTokenRepoImpl
import dagger.Module
import dagger.Provides

typealias RepositorySessionTokenReader = SessionTokenReader
typealias DataSourceSessionTokenReader = com.panhuk.datasource.SessionTokenReader

@Module
class SessionTokenRepoModule {

  @Provides
  fun provideSessionReader(
    @Api sessionTokenApiReader: DataSourceSessionTokenReader,
    @Cache sessionTokenCacheReader: DataSourceSessionTokenReader,
    sessionTokenCache: SessionTokenCache
  ): RepositorySessionTokenReader = SessionTokenRepoImpl(
    sessionTokenApiReader, sessionTokenCacheReader, sessionTokenCache
  )
}