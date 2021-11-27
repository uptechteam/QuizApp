package com.panhuk.datasourcedi.di

import com.panhuk.datasource.SessionTokenDataSource
import com.panhuk.datasourceimpl.SessionTokenLocalDataSource
import dagger.Module
import dagger.Provides

@Module
class SessionTokenModule {

  @Provides
  fun provideSessionTokenDataSource(): SessionTokenDataSource =
    SessionTokenLocalDataSource
}