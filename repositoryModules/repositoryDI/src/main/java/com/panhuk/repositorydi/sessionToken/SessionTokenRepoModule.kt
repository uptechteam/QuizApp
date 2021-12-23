package com.panhuk.repositorydi.sessionToken

import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasource.SessionTokenDSReader
import com.panhuk.datasourcedi.di.Api
import com.panhuk.datasourcedi.di.Cache
import com.panhuk.repository.SessionTokenRepoReader
import com.panhuk.repository_impl.sessionToken.SessionTokenRepoImpl
import dagger.Module
import dagger.Provides

@Module
class SessionTokenRepoModule {
  @Provides
  fun provideSessionReader(
    @Api sessionTokenApiReader: SessionTokenDSReader,
    @Cache sessionTokenCacheReader: SessionTokenDSReader,
    sessionTokenCache: SessionTokenCache
  ): SessionTokenRepoReader = SessionTokenRepoImpl(
    sessionTokenApiReader, sessionTokenCacheReader, sessionTokenCache
  )
}