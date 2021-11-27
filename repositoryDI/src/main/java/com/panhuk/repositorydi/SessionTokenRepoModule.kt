package com.panhuk.repositorydi

import com.panhuk.datasource.SessionTokenDataSource
import com.panhuk.repository.SessionTokenReader
import com.panhuk.repository_impl.SessionTokenRepoImpl
import dagger.Module
import dagger.Provides

@Module
class SessionTokenRepoModule {

  @Provides
  fun provideSessionReader(
    sessionTokenDataSource: SessionTokenDataSource
  ): SessionTokenReader = SessionTokenRepoImpl(sessionTokenDataSource)
}